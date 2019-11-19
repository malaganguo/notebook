package com.mlgg.thinkInJava.entity;

/**
 * <Description> <br>
 *
 * @author zhang.yifei4<br>
 * @Date 13:50 2019/11/6
 * @see com.mlgg.thinkInJava.entity
 */
public class NoImplCloneableEntity {

    private String aaa;

    private int bbb;

    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

    public int getBbb() {
        return bbb;
    }

    public void setBbb(int bbb) {
        this.bbb = bbb;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
