package cn.tedu.mvcboot01.pojo.dto;

public class BMIDTO {
    private double weight;
    private double height;
    private double BMI;

    @Override
    public String toString() {
        return "BMIDTO{" +
                "weight=" + weight +
                ", height=" + height +
                ", BMI=" + BMI +
                '}';
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBMI() {
        BMI = (weight / (height * height));
        return BMI;
    }

    public void setBMI(double BMI) {
        this.BMI = BMI;
    }
}
