package com.ravi.learn.arraysAndArrayList;

public class DominantIndexSol {


    public static void main(String[] args) {
        DominantIndexSol sol = new DominantIndexSol();
        int[] nums = {1,0};
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {3};
        int[] nums3 = {-2,-1,-1};
        System.out.println(sol.dominantIndex(nums));
        System.out.println(sol.dominantIndex(nums1));
        System.out.println(sol.dominantIndex(nums2));
        System.out.println(sol.dominantIndex(nums3));
    }

    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int largest = nums[0];
        int secondLargest = 0;
        int index = 0;

        for (int i = 1 ; i < nums.length; i++) {
            if(nums[i] > largest) {
                index = i;
                secondLargest = largest;
                largest = nums[i];
            } else if(nums[i] > secondLargest) {
                secondLargest = nums[i];
            }
        }
        if (largest / 2 >= secondLargest) {
            return index;
        }
        return -1;
    }


}
