package com.example.kidmath.databse;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int user_id;

    @ColumnInfo(name = "marks")
    private int marks;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "typeOfTest")
    private String typeOfTest;

    public User(int marks, String date, String typeOfTest) {
        this.marks = marks;
        this.date = date;
        this.typeOfTest = typeOfTest;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTypeOfTest() {
        return typeOfTest;
    }

    public void setTypeOfTest(String typeOfTest) {
        this.typeOfTest = typeOfTest;
    }
}
