package com.conformity.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.conformity.dal.mapper.SpringCloudUserMapper;
import com.conformity.dal.model.SpringCloudUser;
import com.conformity.dto.PageDTO;
import com.conformity.service.SpringCloudUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author guolei
 * @since 2024/7/22 11:43
 */
@Service
@Slf4j
public class SpringCloudUserServiceImpl extends ServiceImpl<SpringCloudUserMapper, SpringCloudUser> implements SpringCloudUserService {
    @Override
    public Page<SpringCloudUser> queryCloudUser(PageDTO<SpringCloudUser> pageDTO) {
        log.info("查询cloud用户入参:{}", JSONObject.toJSONString(pageDTO));
        Page<SpringCloudUser> page = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        LambdaQueryWrapper<SpringCloudUser> wrapper = Wrappers.lambdaQuery();
        wrapper.like(Objects.nonNull(pageDTO.getParam()), SpringCloudUser::getUserName, pageDTO.getParam().getUserName());
        return this.page(page, wrapper);
    }

    @Override
    public boolean addSpringCloudUser(SpringCloudUser springCloudUser) {
        springCloudUser.setCreateTime(LocalDateTime.now());
        springCloudUser.setUpdateTime(LocalDateTime.now());
        return this.save(springCloudUser);
    }
}
