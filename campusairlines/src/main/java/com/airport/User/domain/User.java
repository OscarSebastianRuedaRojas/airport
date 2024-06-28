package com.airport.User.domain;

public class User {
    private String id;
    private String password;
    private int userTypeId;

    
    public User() {
    }


    public User(String id, String password, int userTypeId) {
        this.id = id;
        this.password = password;
        this.userTypeId = userTypeId;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public int getUserTypeId() {
        return userTypeId;
    }


    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    
}
