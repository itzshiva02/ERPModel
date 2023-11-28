package com.spectrics.erpproject.model;

public class ClientModel {

    String name, id,phone,address, email,deadline,amount_paid,project_des;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getAmount_paid() {
        return amount_paid;
    }

    public void setAmount_paid(String amount_paid) {
        this.amount_paid = amount_paid;
    }

    public String getProject_des() {
        return project_des;
    }

    public void setProject_des(String project_des) {
        this.project_des = project_des;
    }

    public ClientModel(String name, String id, String phone, String address, String email,String deadline, String amount_paid,String project_des) {
        this.name = name;
        this.phone = phone;
        this.id = id;
        this.address = address;
        this.email = email;
        this.deadline = deadline;
        this.amount_paid = amount_paid;
        this.project_des = project_des;
    }

}
