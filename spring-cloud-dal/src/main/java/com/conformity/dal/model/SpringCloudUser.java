package com.conformity.dal.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author guolei
 * @since 2024/7/22 11:41
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpringCloudUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "uuid", type = IdType.ASSIGN_ID)
    private String uuid;

    private String userName;

    private String userId;

    private String phone;

    private String email;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String status;
}
