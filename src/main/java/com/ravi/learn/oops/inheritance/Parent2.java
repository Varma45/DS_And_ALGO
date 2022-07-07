package com.ravi.learn.oops.inheritance;

public class Parent2 {
    public int noAccessVar;

    public Parent2(int noAccessVar) {
        this.noAccessVar = noAccessVar;
    }

    public int canAccessThisMethod() {
        return this.noAccessVar;
    }

}
