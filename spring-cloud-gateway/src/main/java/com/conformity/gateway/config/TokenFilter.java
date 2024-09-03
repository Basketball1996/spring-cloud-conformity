package com.conformity.gateway.config;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.shaded.com.google.common.base.Stopwatch;
import com.conformity.UUIDUtils;
import com.conformity.constanst.CommonConstants;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;


/**
 * @author guolei
 */
@Slf4j
@Component
public class TokenFilter implements GlobalFilter, Ordered {
    private static final String TRACE_ID = "X-TRACEID";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Stopwatch stopWatch = Stopwatch.createStarted();
        setTraceId();
        // 请求对象
        ServerHttpRequest request = exchange.getRequest();
        // 响应对象
        ServerHttpResponse response = exchange.getResponse();
        String uri = request.getURI().getPath();
        log.info("{} uri:{},{}", request.getMethod(), uri, request.getMethod());
        // 从请求中获取 token 参数
        String token = exchange.getRequest().getHeaders().getFirst(CommonConstants.REQUEST_HEADER);
        // 如果为空，那么将返回 401
        if (token == null || token.isEmpty()) {
            // 响应消息内容对象
            JSONObject message = new JSONObject();
            // 响应状态
            message.put("code", -1);
            // 响应内容
            message.put("msg", "缺少凭证");
            // 转换响应消息内容对象为字节
            byte[] bits = message.toJSONString().getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = response.bufferFactory().wrap(bits);
            // 设置响应对象状态码 401
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            // 设置响应对象内容并且指定编码，否则在浏览器中会中文乱码
            response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
            // 返回响应对象
            return response.writeWith(Mono.just(buffer));
        }
        // 获取请求地址
        String beforePath = request.getPath().pathWithinApplication().value();
        return chain.filter(exchange).doFinally(onFinally -> {
            stopWatch.stop();
            String afterPath = request.getPath().pathWithinApplication().value();
            exchange.getResponse();
            log.info("请求服务响应状态:{}", exchange.getResponse().getStatusCode());
            long elapsed = stopWatch.elapsed(TimeUnit.MILLISECONDS);
            if (elapsed > 3000L) {
                log.warn("慢请求。{}请求耗时:{}ms", afterPath, elapsed);
            }
            log.info("{}->{}请求耗时:{}ms", beforePath, afterPath, elapsed);
            MDC.remove(TRACE_ID);
        });
    }

    @Override
    public int getOrder() {
        return 0;
    }

    private void setTraceId() {
        MDC.put(TRACE_ID, UUIDUtils.getUUID());
    }
}
