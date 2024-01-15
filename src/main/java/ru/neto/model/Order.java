package ru.neto.model;

public class Order {
    private int id;
    private String date;
    private int customer_id;
    private String product_name;
    private int amount;

    public Order(int id, String date, int customer_id, String product_name, int amount) {
        this.id = id;
        this.date = date;
        this.customer_id = customer_id;
        this.product_name = product_name;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
