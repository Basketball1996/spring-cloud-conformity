package com.conformity.dto;

import lombok.Data;

/**
 * @author guolei
 * @since 2024/7/25 11:29
 */

@Data
public class PageDTO<T>{

    private int pageNo = 1;

    private int pageSize = 10;

    private T param;

}
