package com.example.f1;

public class ModelProduct {

    String name, price,image;
    public ModelProduct(){

    }

    public ModelProduct(String name, String price) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
    public String getImage() {
        return image;
    }
}
