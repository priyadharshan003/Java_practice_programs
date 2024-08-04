package com.pri;
import java.lang.*;
import java.io.*;

public class Student {
    String name;
    int roll;

    public Student() {
    }

    public Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }


    void show(String name,int roll){
        System.out.println(this.name+" ("+this.roll+") "+"have 5 skills");
    }

    void show2(){
        System.out.println("have 5 skills");
    }

}
