package com.conformity.result;

/**
 * @author xujian
 * @date 2022/5/17
 */
public class ResultUtil {
    public static Result<String> success() {
        Result<String> ret = new Result<>();
        ret.setCode(ResultCode.SUCCESS.getCode());
        ret.setMessage(ResultCode.SUCCESS.getMsg());
        return ret;
    }

    public static <T> Result<T> success(T data) {
        Result<T> ret = new Result<>();
        ret.setCode(ResultCode.SUCCESS.getCode());
        ret.setMessage(ResultCode.SUCCESS.getMsg());
        ret.setData(data);
        return ret;
    }

    public static Result<String> success(String msg) {
        Result<String> ret = success();
        ret.setData(msg);
        return ret;
    }

    public static <T> Result<T> success(T data, String msg) {
        Result<T> ret = new Result<>();
        ret.setCode(ResultCode.SUCCESS.getCode());
        ret.setData(data);
        ret.setMessage(msg);
        return ret;
    }


    public static <T> Result<T> fail(T data, String msg) {
        Result<T> ret = new Result<>();
        ret.setCode(ResultCode.FAIL.getCode());
        ret.setData(data);
        ret.setMessage(msg);
        return ret;
    }

    public static Result<String> fail(String msg) {
        Result<String> ret = new Result<>();
        ret.setCode(ResultCode.FAIL.getCode());
        ret.setMessage(ResultCode.FAIL.getMsg());
        ret.setData(msg);
        return ret;
    }

}
