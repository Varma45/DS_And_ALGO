package com.ravi.learn.oops.inheritance;

import java.util.Vector;

public class Child extends Parent {
    private int childAccess;

    public Child(int childAccess) {
        super(20, 200);
        this.childAccess = childAccess;

    }

    public Child(){}

    public void printNum() {
        System.out.println(super.canAccessThisMethod());
        System.out.println(super.accessNumber);
        System.out.println(this.childAccess);
    }

    public int canAccessThisMethod() {
        return super.canAccessThisMethod();
    }

    static class TestInheritance{
        public static void main(String[] args) {
            Parent parent = new Child();
            System.out.println(parent.canAccessThisMethod());
            System.out.println(parent.accessNumber);
            System.out.println(" --------- ");
            Child child = new Child();
            child.printNum();
            Child child1 = new Child(101);
            child1.printNum();
        }
    }

}
