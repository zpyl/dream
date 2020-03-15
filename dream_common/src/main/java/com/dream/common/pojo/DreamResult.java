package com.dream.common.pojo;

import java.io.Serializable;

public class DreamResult implements Serializable {
    //定义响应的状态码
    private Integer status;
    //响应之后的提示信息
    private String msg;
    //响应如果带数据，封装到data
    private Object data;
    /**
     *提供几个静态工厂的方法，用来返回结果对象同时设置响应结果
     */
    /**成功*/
    public static DreamResult ok(Object data){
        return new DreamResult(data);
    }
    public static DreamResult ok(){
        return new DreamResult(null);
    }
    /**失败*/
    public static DreamResult build(Integer status,String msg , Object data){
        return new DreamResult(status,msg,data);
    }
    public DreamResult(Object data){
        status=200;
        this.data=data;
        msg="ok";
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

    public DreamResult() {
    }

    public DreamResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
}
