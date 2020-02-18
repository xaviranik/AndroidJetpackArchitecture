package com.xavir.androidjetpackarch.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_table")
public class Task {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String description;
    private String priorty;

    public Task(String title, String description, String priorty) {
        this.title = title;
        this.description = description;
        this.priorty = priorty;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPriorty() {
        return priorty;
    }
}
