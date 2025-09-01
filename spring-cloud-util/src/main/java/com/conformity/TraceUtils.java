package com.conformity;

import com.conformity.constanst.CommonConstants;
import org.slf4j.MDC;

/**
 * @author guolei
 * @since 2024/9/3 10:13
 */
public class TraceUtils {

    public static void setTraceId() {
        MDC.put(CommonConstants.TRACE_ID, UUIDUtils.getUuId());
    }

    public static void removeTraceId(String traceId) {
        MDC.remove(CommonConstants.TRACE_ID);
    }

}
