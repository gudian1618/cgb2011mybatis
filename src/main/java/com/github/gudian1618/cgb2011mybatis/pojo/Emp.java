package com.github.gudian1618.cgb2011mybatis.pojo;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/2/18 8:09 下午
 * 用于封装员工信息的实体类
 */

public class Emp {
    private Integer id;
    private String name;
    private String job;
    private Double salary;

    @Override
    public String toString() {
        return "Emp{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", job='" + job + '\'' +
            ", salary=" + salary +
            '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
