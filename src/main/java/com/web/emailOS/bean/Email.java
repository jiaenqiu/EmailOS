package com.web.emailOS.bean;

import java.io.Serializable;

public class Email implements Serializable {
    private int email_id;
    private String email_rank;
    private String email_name;
    private String email_phone;
    private String email_str;
    private boolean email_flag;

    public int getEmail_id() {
        return email_id;
    }

    public void setEmail_id(int email_id) {
        this.email_id = email_id;
    }

    public String getEmail_rank() {
        return email_rank;
    }

    public void setEmail_rank(String email_rank) {
        this.email_rank = email_rank;
    }

    public String getEmail_name() {
        return email_name;
    }

    public void setEmail_name(String email_name) {
        this.email_name = email_name;
    }

    public String getEmail_phone() {
        return email_phone;
    }

    public void setEmail_phone(String email_phone) {
        this.email_phone = email_phone;
    }

    public String getEmail_str() {
        return email_str;
    }

    public void setEmail_str(String email_str) {
        this.email_str = email_str;
    }

    public boolean isEmail_flag() {
        return email_flag;
    }

    public void setEmail_flag(boolean email_flag) {
        this.email_flag = email_flag;
    }
}
