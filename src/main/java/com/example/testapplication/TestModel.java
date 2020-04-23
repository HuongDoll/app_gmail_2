package com.example.testapplication;

import android.graphics.drawable.Drawable;

import java.util.Random;

public class TestModel {
    String name;
    String message;
    String time;
    int pic;
    Boolean issellect;

    public TestModel(String name, String message, String time) {
        this.name = name;
        this.message = message;
        this.time = time;
        Random random = new Random();
        this.pic = random.nextInt();
        this.issellect=false;
    }

    public int getPic() {
        return pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getIssellect() {
        return issellect;
    }

    public void setIssellect(Boolean issellect) {
        this.issellect = issellect;
    }
}
