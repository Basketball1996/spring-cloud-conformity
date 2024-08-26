package com.conformity.result;

import lombok.Getter;

/**
 * @author guolei
 */

@Getter
public enum ResultCode {
    SUCCESS(200, "成功"),
    FAIL(100, "失败"),
    FAIL_3(300, "没有符合条件的数据"),
    FAIL_4(400, "非法参数或者参数格式错误"),
    FAIL_500(500, "服务器内部错误"),
    BAD_REQUEST(400, "非法参数或者参数格式错误");

    private final int code;
    private final String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
