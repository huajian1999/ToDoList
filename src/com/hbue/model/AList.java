package com.hbue.model;

public class AList {
    private Integer id;
    private String name;

    public AList() {
    }

    public AList(String name) {
        this.name = name;
    }
    public AList(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "AList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
