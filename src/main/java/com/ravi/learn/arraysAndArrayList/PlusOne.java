package com.ravi.learn.arraysAndArrayList;

public class PlusOne {

    public int[] plusOne(int[] digits) {

        boolean all9s = true;

        for (int i : digits) {
            if ( i != 9 ) {
                all9s = false;
                break;
            }
        }

        if (all9s) {
            int[] temp = new int[digits.length + 1] ;
            temp[0] = 1;
            for (int i = 1 ; i < temp.length ; i++) {
                temp[i] = 0;
            }
            return temp;
        }

        boolean isUnits9 = (digits[digits.length-1] == 9) ;

        if (isUnits9) {
            int carry = 1;
            digits[digits.length - 1] = 0;
            for (int i = digits.length - 2 ; i >=0 ; i --) {
                if (carry!=1) {
                    break;
                } else if (digits[i] == 9) {
                    digits[i] = 0;
                    carry = 1;
                } else {
                    digits[i] = digits[i] + 1;
                    carry = 0;
                }

            }
        } else {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
        }

        return digits;
    }

    static class Solution{
        static int[] nums = new int[]{9,9,9};

        public static void main(String[] args) {
            PlusOne plusOne = new PlusOne();
            int[] plusOneArr = plusOne.plusOne(nums);
            for (int i : plusOneArr) {
                System.out.print(i+"   ");
            }
        }
    }

}


