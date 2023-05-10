package cn.tedu.mybatisexercise.pojo.entity;

import java.util.Date;

public class Order {
    private int id;
    private String state;
    private double amount;
    private Date created;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", amount=" + amount +
                ", created=" + created +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}


