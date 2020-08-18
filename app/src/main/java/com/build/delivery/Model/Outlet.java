package com.build.delivery.Model;

public class Outlet {
    private String img;
    private String outlate;
    private String rating;
    private String people;

    public Outlet(String outlate, String rating, String people) {
//        this.img = img;
        this.outlate = outlate;
        this.rating = rating;
        this.people = people;

    }

//    public String getImg() {
//        return img;
//    }
//
//    public void setImg(String img) {
//        this.img = img;
//    }

    public String getOutlate() {
        return outlate;
    }

    public void setOutlate(String outlate) {
        this.outlate = outlate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }
}
