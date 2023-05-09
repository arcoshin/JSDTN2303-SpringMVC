package cn.tedu.mybatisexercise.pojo.vo;

import java.util.Date;

public class OrderVO {
    private String state;
    private double amount;

    @Override
    public String toString() {
        return "Order{" +
                ", state='" + state + '\'' +
                ", amount=" + amount +
                '}';
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
}


