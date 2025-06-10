package com.conformity.dal.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
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
@Schema(description = "用户实体类")
public class SpringCloudUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "uuid", type = IdType.ASSIGN_ID)
    @Schema(description = "主键ID")
    private String uuid;

    @Schema(description = "用户名称")
    private String userName;

    @Schema(description = "用户ID")
    private String userId;

    @Schema(description = "电话")
    private String phone;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @Schema(description = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    @Schema(description = "状态")
    private String status;
}
