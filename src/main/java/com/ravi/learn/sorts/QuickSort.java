package com.ravi.learn.sorts;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class QuickSort {
    public int[] sort(int[] inputArr) {

        Instant start = Instant.now();
        int leftBound = 0;
        int rightBound = inputArr.length - 1;
        quickSort(inputArr, leftBound, rightBound);
        Instant end = Instant.now();
        System.out.println("\nQuick Sort Duration : " + Duration.between(start, end));
        return inputArr;
    }

    private void quickSort(int[] arr, int leftBound, int rightBound) {

        if (leftBound >= rightBound) return;

        int leftPtr = getLeftPtr(arr, leftBound, rightBound);

        quickSort(arr, leftBound, leftPtr-1);
        quickSort(arr, leftPtr +1 , rightBound);


    }

    private int getLeftPtr(int[] arr, int leftBound, int rightBound) {

        int pivotIndex = new Random().nextInt(rightBound-leftBound) + leftBound;
        int pivot = arr[pivotIndex];
        //swap the random pivot with the last element of arr
        swap(arr, pivotIndex, rightBound);
        pivotIndex = rightBound;

        int leftPtr = leftBound;
        int rightPtr = rightBound - 1;

        while(leftPtr < rightPtr) {

            while (arr[leftPtr] <= pivot && leftPtr < rightPtr) {
                leftPtr++;
            }

            while(arr[rightPtr] >= pivot && leftPtr < rightPtr) {
                rightPtr--;
            }

            if(leftPtr!=rightPtr){
                swap(arr, leftPtr, rightPtr);
            }

        }

        //ptr stops at the number which is greater than pivot or if all numbers are covered +
        // + and none is greater than pivot
        //swap pivot with leftPtr if leftPtr == rightPtr
        //swap the left number with right number if leftPtr!=rightPtr i.e there are numbers in between them.
        //System.out.println("LP : " + leftPtr + "  , RP : " + rightPtr);
        //if (leftPtr == rightPtr) {
            if (arr[leftPtr] > arr[pivotIndex]) {
                swap(arr, leftPtr, pivotIndex);
                pivotIndex = leftPtr;
            }
        //}

        return pivotIndex;
    }

    private void swap(int[] arr, int leftPtr, int rightPtr){
        int temp = arr[leftPtr] ;
        arr[leftPtr] = arr[rightPtr];
        arr[rightPtr] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] inputArr = new int[100];
        Random rd = new Random();
        for (int i = 0 ; i < 100; i++) inputArr[i] = rd.nextInt(100);

        int[] sortedArr = quickSort.sort(inputArr);
        for (int element : sortedArr) {
            System.out.print( element + " ");
        }
    }


}
