package com.spectrics.erpproject.model;

public class ExpenseModel {

    String name,id,food, accommodation,travel,date;

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

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }

    public String getTravel() {
        return travel;
    }

    public void setTravel(String travel) {
        this.travel = travel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ExpenseModel(String name,String id,String food,String accommodation,String travel,String date){
        this.name = name;
        this.id = id;
        this.accommodation = accommodation;
        this.travel = travel;
        this.food = food;
        this.date = date;
    }


}
