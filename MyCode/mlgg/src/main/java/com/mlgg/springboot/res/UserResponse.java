package com.mlgg.springboot.res;

import lombok.Data;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 17:03 2019/12/12
 * @see com.mlgg.springboot.res
 */
@Data
public class UserResponse {

    private String username;
    private String password;
    private Integer age;
    private String email;

    public static class Builder {
        private String username;
        private String password;
        private Integer age = -1;
        private String email = "xxx";

        public Builder(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public Builder age(Integer val) {
            this.age = val;
            return this;
        }
        public Builder email(String val) {
            this.email = val;
            return this;
        }
        public UserResponse builder() {
            return new UserResponse(this);
        }
    }
    UserResponse(Builder builder) {
        username = builder.username;
        password = builder.password;
        age = builder.age;
        email = builder.email;
    }
}
