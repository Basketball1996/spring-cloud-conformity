package com.conformity.result;

import lombok.Data;

/**
 * @author guolei
 */
@Data
public class Result<T> {

    /**
     * 消息码
     */
    private int code;
    /**
     * 详细信息提示
     */
    private String message;
    /**
     * 数据
     */
    private T data;

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

}