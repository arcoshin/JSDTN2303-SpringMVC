package cn.tedu.mvcemp.pojo.entity;

public class Emp {
    private Integer id;
    private String title;
    private double salary;
    private String job;

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", salary=" + salary +
                ", job='" + job + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
