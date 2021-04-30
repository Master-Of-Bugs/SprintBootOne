package com.anatkush.springboot;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ToDo {

    @Id
    private long id;
    private String title;
    private String dueDate;

    public ToDo(){

    }

    public ToDo(Long id, String title, String dueDate) {
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
