package com.conformity.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.conformity.dal.model.SpringCloudUser;
import com.conformity.dto.PageDTO;

import java.util.List;

/**
 * @author guolei
 * @since 2024/7/22 11:42
 */
public interface SpringCloudUserService extends IService<SpringCloudUser> {

    /**
     * 分页查询用户
     * @param pageDTO
     * @return
     */
    Page<SpringCloudUser> queryCloudUser(PageDTO<SpringCloudUser> pageDTO);
}
