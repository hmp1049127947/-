package com.wyu160802.dto;

/**
 * @author 黄明潘
 * @date 2019/7/26-20:32
 */
public class BaseResult {

    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL= 500;
    public int status;
    public String message;
    public Object data;

    public BaseResult(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResult(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public BaseResult(Object data) {
        this.status = STATUS_SUCCESS;
        this.message = "success";
        this.data = data;
    }

    public BaseResult() {
    }

    /**
     *  status=200,message='success',data=null
     * @return
     */
    public static BaseResult success() {
        return new BaseResult(null);
    }

    /**
     * status=200,message='success',this.data=data
     * @param data
     * @return
     */
    public static BaseResult success(Object data) {
        return new BaseResult(data);
    }

    /**
     * status=200,this.message=message,data=null
     * @param message
     * @return
     */
    public static BaseResult success(String message) {
        return new BaseResult(STATUS_SUCCESS,message);
    }

    /**
     * status=200,this.message=message,this.data=data
     * @param message
     * @return
     */
    public static BaseResult success(String message, Object data) {
        return new BaseResult(STATUS_SUCCESS,message,data);
    }

    /**
     * status=500,this.message='fail',data=null
     * @return
     */
    public static BaseResult fail() {
        return new BaseResult(STATUS_FAIL, "fail");
    }

    /**
     * status=500,this.message=message,data=null
     * @param message
     * @return
     */
    public static BaseResult fail(String message) {
        return new BaseResult(STATUS_FAIL, message);
    }

    /**
     * this.status=status,this.message=message
     * @param status
     * @param message
     * @return
     */
    public static BaseResult fail(int status, String message) {
        return new BaseResult(status, message);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 增删改查处理信息
     * @param i
     * @param operate
     * @return
     */
    public static BaseResult CrudMsg(int i,String operate) {
        if (i == 1) {
            return BaseResult.success(operate+"成功");
        } else {
            return BaseResult.fail(operate+"失败");
        }
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
