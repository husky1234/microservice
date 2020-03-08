package com.atguigu.springcloud.entities;

public class PaymentEntity {
    private int id;
    private String series;

    public PaymentEntity() {
    }

    public PaymentEntity(int id, String series) {
        this.id = id;
        this.series = series;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "PaymentEntity{" +
                "id=" + id +
                ", series='" + series + '\'' +
                '}';
    }
}
