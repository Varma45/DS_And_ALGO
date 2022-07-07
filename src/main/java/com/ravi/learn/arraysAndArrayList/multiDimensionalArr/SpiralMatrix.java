package com.ravi.learn.arraysAndArrayList.multiDimensionalArr;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length - 1;
        int n = matrix[0].length - 1;

        int limit = n;
        if (m<n) {
            limit = m;
        }

        List<Integer> resultList = new ArrayList<>();

        boolean breaker = false;

        for (int i = 0 ; i <= limit; i ++) {

            for (int j = i ; j <= n-i ; j++) {
                if (areAllElementsAdded(m,n,resultList)) break;
                resultList.add(matrix[i][j]);
            }
            int firstCol = n - i;
            for (int j = i + 1 ; j <= m-i ; j++) {
                if (areAllElementsAdded(m,n,resultList)) break;
                resultList.add(matrix[j][firstCol]);
            }
            int secondRow = m - i;
            for (int j = n - i - 1; j >=i ; j--) {
                if (areAllElementsAdded(m,n,resultList)) break;
                resultList.add(matrix[secondRow][j]);
            }
            for (int j = m-i-1 ; j>i; j-- ){
                if (areAllElementsAdded(m,n,resultList)) break;
                resultList.add(matrix[j][i]);
            }

        }


        return resultList;
    }

    private boolean areAllElementsAdded(int m, int n, List<Integer> resultList) {
        boolean breaker = false;
        if (resultList.size()>=(m+1)*(n+1)) breaker = true;
        return breaker;
    }

    static class Solution{
        public static void main(String[] args) {
            int[][] matrix = new int[3][4];
            matrix[0] = new int[]{1,2,3,4};
            matrix[1] = new int[]{5,6,7,8};
            matrix[2] = new int[]{9,10,11,12};
            /*int[][] matrix = new int[1][1];
            matrix[0] = new int[]{1};*/
            SpiralMatrix spiralMatrix = new SpiralMatrix();
            List<Integer> result =  spiralMatrix.spiralOrder(matrix);
            for (int i = 0; i < result.size() ; i++) {
                System.out.print(result.get(i) + "   ");
            }
        }
    }

}


