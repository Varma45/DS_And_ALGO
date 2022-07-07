package com.ravi.learn.arraysAndArrayList.multiDimensionalArr;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();

        System.out.println(coefficient(13,1));
        System.out.println(coefficient(13,2));

        for (int row = 0 ; row < numRows ; row++) {
            List<Integer> currentRowList = new ArrayList<>();
            for (int i = 0 ; i <= row ; i++ ) {
                currentRowList.add(coefficient(row, i));
            }
            resultList.add(currentRowList);
        }

        return resultList;
    }

    private int coefficient(int n, int r) {
        int coefficient = (int) (factorial(n)/(factorial(r)*factorial(n-r)));
        return  coefficient;
    }
    private long factorial (int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n-1);
    }

    static class Solution{
        public static void main(String[] args) {
            PascalTriangle pascalTriangle = new PascalTriangle();
            List resultList = pascalTriangle.generate(0);
            printResultList(resultList);
            resultList = pascalTriangle.generate(1);
            printResultList(resultList);
            resultList =  pascalTriangle.generate(15);
            printResultList(resultList);

        }

        private static void printResultList(List resultList) {
            System.out.println();
            for (int i = 0 ; i < resultList.size(); i++) {
                System.out.println();
                List subList = (List)resultList.get(i);
                for (int j = 0 ; j < subList.size(); j++) {
                    System.out.print(subList.get(j)+" ");
                }
            }
        }
    }

}
