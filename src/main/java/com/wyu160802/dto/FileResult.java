package com.wyu160802.dto;

/**
 * @author 黄明潘
 * @date 2019/7/26-20:32
 */
public class FileResult {
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL= 500;
    public int code;
    public String message;

    public FileResult(){

    }

    public FileResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static FileResult success() {
        return getBaseResult(STATUS_SUCCESS, "成功");
    }

    public static FileResult success(String message) {
        return getBaseResult(STATUS_SUCCESS, message);
    }

    public static FileResult fail() {
        return getBaseResult(STATUS_FAIL, "失败");
    }

    public static FileResult fail(String message) {
        return getBaseResult(STATUS_FAIL, message);
    }

    public static FileResult fail(int code, String message) {
        return getBaseResult(code, message);
    }

    private static FileResult getBaseResult(int code, String message) {
        FileResult baseResult = new FileResult();
        baseResult.setCode(code);
        baseResult.setMessage(message);
        return baseResult;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
