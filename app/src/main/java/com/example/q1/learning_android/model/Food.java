package com.example.q1.learning_android.model;

public class Food {
    private String name;
    private int price;
    private int pic;
    private FoodType type;

    public Food(String name, int price, int pic, FoodType type) {
        this.name = name;
        this.price = price;
        this.pic = pic;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public FoodType getType() {
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }
}
