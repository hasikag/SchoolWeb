package com.school.model;

/**
 * Created by IntelliJ IDEA.
 * User: hga
 * Date: 7/2/15
 * Time: 1:37 AM
 * To change this template use File | Settings | File Templates.
 */

public class School {
    private int id;
    private String name;
    private String code;
    private String address;
    private String emailDomain;

    public School() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailDomain() {
        return emailDomain;
    }

    public void setEmailDomain(String emailDomain) {
        this.emailDomain = emailDomain;
    }
}
