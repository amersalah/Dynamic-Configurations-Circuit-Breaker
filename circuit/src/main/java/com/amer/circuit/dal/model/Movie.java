package com.amer.circuit.dal.model;

import java.util.List;

public class Movie {

    private long id;
    private String name;
    private String desc;

    public Movie(){}

    public Movie(long id, String name, String desc, List<Actor> actorList) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.actorList = actorList;
    }

    public Movie(long id) {
        this.id = id;
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }

    private List<Actor> actorList;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", actorList=" + actorList +
                '}';
    }
}



