package com.mlgg.effective;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 14:31 2019/12/12
 * @see com.mlgg.effective
 */
public class User {

    private String username;
    private String password;
    private int age;
    private String email;

    public static class Builder {
        //需要的参数
        private String username;
        private String password;
        //可选参数 默认初始化
        private int age = 0;
        private String email = "111@qq.com";

        public Builder(String username, String password) {
            this.username = username;
            this.password = password;
        }
        public Builder age(int val) {
            age = val;
            return this;
        }
        public Builder email(String val) {
            email = val;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }

    private User(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.age = builder.age;
        this.email = builder.email;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}


