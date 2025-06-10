package com.conformity.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.conformity.dal.model.SpringCloudUser;
import com.conformity.dto.PageDTO;
import com.conformity.result.Result;
import com.conformity.result.ResultUtil;
import com.conformity.service.SpringCloudUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author guolei
 * @since 2024/7/22 16:14
 */

@Tag(name = "用户管理")
@RestController
@RequestMapping("/springCloudUser")
public class SpringCloudUserController {

    @Autowired
    private SpringCloudUserService springCloudUserService;

    @PostMapping("/addSpringCloudUser")
    @ResponseBody
    @Operation(summary = "新增springCloud用户")
    public Result<Boolean> addSpringCloudUser(@RequestBody SpringCloudUser springCloudUser) {
        return ResultUtil.success(springCloudUserService.addSpringCloudUser(springCloudUser));
    }

    @PostMapping("/querySpringCloudUserList")
    @ResponseBody
    @Operation(summary = "查询springCloud用户", description = "查询springCloud用户")
    public Result<Page<SpringCloudUser>> querySpringCloudList(@RequestBody PageDTO<SpringCloudUser> pageDTO) {
        return ResultUtil.success(springCloudUserService.queryCloudUser(pageDTO));
    }
}
