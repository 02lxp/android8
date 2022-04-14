package com.example.databasetest;

public class Book {
    private String name;
    private String price;
    private String category_name;

    public String getCategory_name() {

        return category_name;
    }

    public void setCategory_name(String category_name) {

        this.category_name = category_name;
    }

    public String getPrice() {

        return price;
    }

    public void setPrice(String price) {

        this.price = price;
    }


    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
