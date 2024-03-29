package com.amer.circuit.dal.model;

public class Actor {

    private long id;
    private String name;
    private int age;

    public Actor(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Actor(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
