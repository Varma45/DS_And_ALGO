package com.ravi.learn.exercises;

public class ReverseString {

    public static void main(String[] args) {
        String myString = "Reverse Me";
        String reverseString = new ReverseString().reverser(myString);
        System.out.println(reverseString);
    }

    private String reverser(String input) {
        String reversed = "";
        for (int i = input.length()-1 ; i >=0 ; i -- ) {
            reversed = reversed + input.charAt(i);
        }
        return reversed;
    }


}
