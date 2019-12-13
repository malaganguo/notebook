package com.mlgg.springboot.req;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mlgg.springboot.utils.StringUtils;
import lombok.Data;
import org.omg.CORBA.ObjectHelper;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 17:09 2019/12/12
 * @see com.mlgg.springboot.req
 */
public class UserRequest {
    private String username;
    private String password;
    private Integer age;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String toJsonString() {
        return JSON.toJSONString(this);
    }
}
