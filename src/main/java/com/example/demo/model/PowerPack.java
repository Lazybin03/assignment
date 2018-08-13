package com.example.demo.model;

public class PowerPack {
    long id;
    int power;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public PowerPack(long id, int power) {
        this.id = id;
        this.power = power;
    }

    public PowerPack() {
    }
}
