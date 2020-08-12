package com.build.delivery.Model;

public class Menu {
    private String menu;
    private String price;
    private String rating;
    private String people;

    public Menu(String menu, String price, String rating, String people) {
//        this.img = img;
        this.menu = menu;
        this.price = price;
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

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getPrice() {return price;}

    public void setPrice(String price) { this.price = price; }

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
