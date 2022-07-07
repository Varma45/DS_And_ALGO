package com.ravi.learn.arraysAndArrayList;

public class TestPivot {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1,-1,-1,-1,-1,0};
        System.out.println(solution.pivotIndex2(nums));
    }


}


class Solution {
    public int pivotIndex(int[] nums) {

        int totalSum = 0;

        for (int i = 0 ; i < nums.length; i++) {
            totalSum = totalSum + nums[i];
        }

        boolean isEven = (totalSum % 2) == 0;

        int sum = 0 ;
        for (int i = 0 ; i < nums.length; i++) {
            if(isEven) {
                // Every element is getting summed
                sum = sum + nums[i];
                // Every element is getting checked
                if((nums[i] % 2) == 0 ) {
                    if ( totalSum + nums[i] == 2 * sum ) {
                        return i;
                    }
                }
            }

            if(!isEven) {
                sum = sum + nums[i];
                if ((nums[i] % 2) == 1 || (nums[i] % 2) == -1) {
                    if (totalSum + nums[i] == 2 * sum) {
                        return i;
                    }
                }
            }

        }
        return -1;

    }

    public int pivotIndex2(int[] nums) {

        int totalSum = 0;

        for (int i = 0 ; i < nums.length; i++) {
            totalSum = totalSum + nums[i];
        }

        boolean isEven = (totalSum % 2) == 0;

        int currentSum = 0 ;
        for (int i = 0 ; i < nums.length; i++) {
            currentSum = currentSum + nums[i];
            if ( totalSum == (2 * currentSum) - nums[i] ) {
                return i;
            }
        }
        return -1;

    }


}