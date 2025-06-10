package com.conformity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guolei
 * @since 2024/7/25 11:29
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "分页公共类")
public class PageDTO<T> {

    @Schema(description = "页码")
    private int pageNo = 1;

    @Schema(description = "页数")
    private int pageSize = 10;

    @Schema(description = "泛型类")
    private T param;

}
