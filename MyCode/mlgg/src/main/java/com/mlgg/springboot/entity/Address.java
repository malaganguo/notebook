package com.mlgg.springboot.entity;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 17:27 2019/11/11
 * @see com.mlgg.springboot.entity
 */
public class Address {
    private String lastName;
    private String firstName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Address{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
