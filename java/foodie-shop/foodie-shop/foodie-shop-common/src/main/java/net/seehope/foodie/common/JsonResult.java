package net.seehope.foodie.common;

public class JsonResult {
    /**
     * 响应状态码，和前端约好，什么错误返回什么样的状态码
     * 200 表示成功
     * 500 表示异常
     */
    private Integer status;

    /**
     * 错误提示，是有状态码失败的情况下才有用，
     * 告诉前端，响应错误的具体原因
     */
    private String msg;

    /**
     * 数据区域，如果响应成功，那么接口数据放在data中
     */
    private Object data;

    /**
     * 成功的话，将数据返回
     * @param data
     * @return
     */
    public static JsonResult isOk(Object data) {
        return new JsonResult(200, "ok", data);
    }

    /**
     * 500异常，返回错误信息
     * @param msg
     * @return
     */
    public static JsonResult errorMsg(String msg) {
        return new JsonResult(500, msg, null);
    }

    public JsonResult() {}

    public JsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
