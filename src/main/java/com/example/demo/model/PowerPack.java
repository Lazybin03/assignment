package com.example.demo.model;

public class PowerPack {
    String id;
    int power;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public PowerPack(String id, int power) {
        this.id = id;
        this.power = power;
    }

    public PowerPack() {
    }
}
