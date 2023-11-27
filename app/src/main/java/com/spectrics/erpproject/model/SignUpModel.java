package com.spectrics.erpproject.model;
public class SignUpModel {

    String name, email, username, password,status,phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
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

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }
    public SignUpModel(String name, String email, String username, String password,String status) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.status = status;
        this.phone = phone;
    }

}