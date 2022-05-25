package com.t2010a.hellot2010aagain.controller;

import javax.servlet.http.HttpServlet;

public class Account extends HttpServlet {

    private String username;
    private String password;
    private String email;
    private String phone;


    public Account() {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
