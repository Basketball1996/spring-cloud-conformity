package com.conformity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.conformity.dal.mapper.SpringCloudUserMapper;
import com.conformity.dal.model.SpringCloudUser;
import com.conformity.dto.PageDTO;
import com.conformity.service.SpringCloudUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guolei
 * @since 2024/7/22 11:43
 */

@Service
@Slf4j
public class SpringCloudUserServiceImpl extends ServiceImpl<SpringCloudUserMapper, SpringCloudUser> implements SpringCloudUserService {
    @Override
    public Page<SpringCloudUser> queryCloudUser(PageDTO<SpringCloudUser> pageDTO) {

        LambdaQueryWrapper<SpringCloudUser> wrapper = Wrappers.lambdaQuery();
        Page<SpringCloudUser> page = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        wrapper.like(StringUtils.isNotBlank(pageDTO.getParam().getUserName()), SpringCloudUser::getUserName, pageDTO.getParam().getUserName());
        return this.page(page, wrapper);
    }
}
