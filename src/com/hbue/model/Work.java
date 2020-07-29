package com.hbue.model;

public class Work {
    private Integer id;
    private String description;
    private String state;
    private Integer listId;

    public Work() {
    }

    public Work(String description, String state, Integer listId) {
        this.description = description;
        this.state = state;
        this.listId = listId;
    }

    public Work(Integer id, String state) {
        this.id = id;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                ", listId=" + listId +
                '}';
    }
}
