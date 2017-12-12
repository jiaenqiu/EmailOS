package com.web.emailOS.bean;

public class ResponseBean {
    private String msg;
    private String result;
    private boolean flag;

    public ResponseBean() {}
    public ResponseBean(String msg,String result,boolean flag) {
        this.msg = msg;
        this.result = result;
        this.flag = flag;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
