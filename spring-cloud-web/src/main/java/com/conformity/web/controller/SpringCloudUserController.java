package com.conformity.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.conformity.dal.model.SpringCloudUser;
import com.conformity.dto.PageDTO;
import com.conformity.service.SpringCloudUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author guolei
 * @since 2024/7/22 16:14
 */

@Api(tags = "用户管理")
@RestController
@RequestMapping("/springCloudUser")
@Slf4j
public class SpringCloudUserController {

    @Resource
    private SpringCloudUserService springCloudUserService;

    @PostMapping("/querySpringCloudList")
    @ResponseBody
    @ApiOperation(value = "查询用户", notes = "查询用户")
    public Page<SpringCloudUser> querySpringCloudList(@RequestBody PageDTO<SpringCloudUser> pageDTO) {
        log.info("查询cloud用户入参:{}", JSONObject.toJSONString(pageDTO));
        return springCloudUserService.queryCloudUser(pageDTO);
    }
}
