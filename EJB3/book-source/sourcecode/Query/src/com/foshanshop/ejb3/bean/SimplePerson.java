package com.foshanshop.ejb3.bean;

public class SimplePerson {
    private String name;

    private boolean sex;

    public SimplePerson() {
    }

    public SimplePerson(String name, boolean sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getDescription() {
        return sex ? name + "ÊÇÄÐº¢" : name + "ÊÇÅ®º¢";
    }
}