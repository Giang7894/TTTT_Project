package com.example.project;

public class Staff {
    private int id;
    private String name;
    private String userName;
    private String password;
    private String role;

    public Staff(int id,String name,String userName,String password,String role) {
        this.id = id;
        this.name=name;
        this.userName=userName;
        this.password=password;
        this.role=role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
