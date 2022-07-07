package com.ravi.learn.oops.inheritance;

public class Parent {
    private int noAccessVar;
    public int accessNumber;


    public Parent() {
        this.noAccessVar = 10;
        this.accessNumber = 100;
    }

    public Parent(int noAccessVar, int accessNumber){
        this.accessNumber = accessNumber;
        this.noAccessVar = noAccessVar;
    }

    private int cannotCallThisMethod() {
        return noAccessVar;
    }

    public int canAccessThisMethod() {
        return accessNumber;
    }

}
