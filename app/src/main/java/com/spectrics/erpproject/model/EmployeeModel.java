package com.spectrics.erpproject.model;

public class EmployeeModel {

    String name, id,phone,address, email,projects_assigned,salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(){
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getProjects_assigned(){
        return projects_assigned;
    }

    public void setProjects_assigned(String projects_assigned) {
        this.projects_assigned = projects_assigned;
    }

    public String getSalary(){
        return salary;
    }

    public void setSalary(){
        this.salary = salary;
    }

    public EmployeeModel(String name, String id, String phone, String address, String email, String projects_assigned, String salary) {
        this.name = name;
        this.phone = phone;
        this.id = id;
        this.address = address;
        this.email = email;
        this.projects_assigned = projects_assigned;
        this.salary = salary;
    }

}
