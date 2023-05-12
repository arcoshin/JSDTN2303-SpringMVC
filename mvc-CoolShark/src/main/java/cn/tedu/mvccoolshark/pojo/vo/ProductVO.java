package cn.tedu.mvccoolshark.pojo.vo;

public class ProductVO {
    private String title;
    private double price;
    private int num;

    @Override
    public String toString() {
        return "ProductVO{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", num=" + num +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
