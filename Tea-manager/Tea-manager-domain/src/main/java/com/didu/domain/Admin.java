package com.didu.domain;

/**
 * Created by Administrator on 2017/10/23.
 */
public class Admin {
    private int id;
    private String num;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

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

    public Admin(int id, String num, String username, String password) {
        this.id = id;
        this.num = num;
        this.username = username;
        this.password = password;
    }

    public Admin(String num, String username, String password) {
        this.num = num;
        this.username = username;
        this.password = password;
    }

    public Admin() {
        super();
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", num=" + num +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
