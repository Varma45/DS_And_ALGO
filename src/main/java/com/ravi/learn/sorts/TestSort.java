package com.ravi.learn.sorts;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

//selection sort
class SelectionSort {

    public int[] sort(int[] inputArr) {

        Instant start = Instant.now();
        int operationcount = 0;
        // 1. iterate over to check the Value lesser than current  and swap it to current index
        for (int i = 0 ; i < inputArr.length -1  ; i ++) {
            int minValue = inputArr[i];
            for (int j = i+1 ; j < inputArr.length ; j++) {
                operationcount++;
                if (inputArr[j] < minValue) {
                    minValue = inputArr[j];
                    inputArr[j] = inputArr[i];
                    inputArr[i] = minValue;
                }
            }
        }
        //System.out.println(operationcount);
        Instant end = Instant.now();
        System.out.println("\n Selection sort: " + Duration.between(start, end));
        return inputArr;
    }

}

//Insertion Sort
class InsertionSort {

    public int[] sort (int[] inputArr) {
        Instant start = Instant.now();

        int operationCount = 0 ;
        //1. Insert unsorted elements to sorted left array
        // check the suitable place for the element to be inserted
        for (int i = 1 ; i < inputArr.length; i++) {
            for ( int j = i - 1 ; j >= 0 ; j--) {
                operationCount++;
                if(inputArr[j+1] > inputArr[j]) break;

                if ( inputArr[j+1] < inputArr[j] ) {
                    int temp = inputArr[j];
                    inputArr[j] = inputArr[j+1];
                    inputArr[j+1] = temp;
                }
            }
        }
        //System.out.println(operationCount);
        Instant end = Instant.now();
        System.out.println("\n Insertion sort: " + Duration.between(start, end));
        return inputArr;
    }

}

//Bubble Sort
class BubbleSort{
    public int[] sort(int[] inputArr) {
        Instant start = Instant.now();

        int operationcount = 0 ;
        //Bubble up large numbers
        //compare pairwise and slowly bubble up bug numbers to the right
        for (int i = inputArr.length - 1 ; i > 0  ; i--) {
            for (int j = 0 ; j < i ; j++ ) {
                operationcount++;
                if (inputArr[j+1]  < inputArr [j] ) {
                    int temp = inputArr[j+1];
                    inputArr[j+1] = inputArr[j];
                    inputArr[j] = temp;
                }
            }
        }
        //System.out.println(operationcount);
        Instant end = Instant.now();
        System.out.println("\n Bubble sort: " + Duration.between(start, end));
        return inputArr;
    }
}

//MergeSort
class MergeSort {

    int operations = 0;
    public int[] sort(int[] inputArr) {
        Instant start = Instant.now();
        int[] sortedArr =  splitAndMerge(inputArr, 0 , inputArr.length - 1);
        Instant end = Instant.now();
        System.out.println("\n Merge sort: " + Duration.between(start, end));
        return sortedArr;

    }

    //Take the complete Array as input and the index of left end and right end
    //Recursively call this method until left bound and right bound are equal
    //Merge leftHalf and rightHalf
    private int[] splitAndMerge(int[] arr, int left, int right) {
        operations++;
        if (left >= right) return new int[]{arr[left]};

        int middle = (left + right)/2;
        int[] leftHalf = splitAndMerge(arr, left, middle);
        int[] rightHalf = splitAndMerge(arr, middle+1, right);
        return mergeHalves(leftHalf, rightHalf);
    }

    //Take a temp arr of size leftHalf Length + Right Half length
    //compare leftHalf and RightHalf elements from left to right
    //Add the smallest element to the temp arr
    private int[] mergeHalves(int[] leftHalf, int[] rightHalf){
        int i = 0, j = 0, index = 0;
        int[] temp = new int[leftHalf.length + rightHalf.length];
        while (i < leftHalf.length && j < rightHalf.length) {
            operations++;
            if (leftHalf[i] < rightHalf[j]) {
                temp[index] = leftHalf[i];
                i++;
            } else {
                temp[index] = rightHalf[j];
                j++;
            }
            index++;
        }
        while(i<leftHalf.length) {
            operations++;
            temp[index] = leftHalf[i];
            i++;
            index++;
        }
        while(j<rightHalf.length) {
            operations++;
            temp[index] = rightHalf[j];
            j++;
            index++;
        }
        //System.out.println(operations);
        return temp;
    }


}



public class TestSort{
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        InsertionSort insertionSort = new InsertionSort();
        BubbleSort bubbleSort = new BubbleSort();

        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();

        /*int[] nums = {1,2,3,4,5,10,6,8,-13,0,4};

        int[] sortedNums = selectionSort.sort(nums);
        System.out.println("\nSelection Sort");
        for (int i : sortedNums) System.out.print(i + "   ");

        System.out.println("\nInsertion sort");
        nums = new int[]{5, 2, 3, 4, 1, 10, 6, 8, -13, 0, 4};
        sortedNums = insertionSort.sort(nums);
        for (int i : sortedNums) System.out.print(i+ "   ");

        System.out.println("\nBubble Sort");
        nums = new int[]{1, 2, 3, 4, 5, 10, 6, 8, -13, 0, 4};
        sortedNums = bubbleSort.sort(nums);
        for (int i : sortedNums) System.out.print(i+ "   ");

        System.out.println("\nMerge Sort");
        nums = new int[]{1, 2, 3, 4, 5, 10, 6, 8, -13, 0, 4};
        sortedNums = mergeSort.sort(nums);
        for (int i : sortedNums) System.out.print(i+ "   ");*/

        int k = 200000;
        int[] random = new int[k];
        Random rd = new Random();
        for (int i = 0 ; i < k ; i ++) {
            random[i] = rd.nextInt();
        }

        int[] sortedArr1 = Arrays.copyOf(random, k);
        int[] sortedArr2 = Arrays.copyOf(random, k);
        int[] sortedArr3 = Arrays.copyOf(random, k);
        int[] sortedArr4 = Arrays.copyOf(random, k);
        int[] sortedArr5 = Arrays.copyOf(random, k);

        sortedArr1 = selectionSort.sort(sortedArr1);
        //printArr(sortedArr1);
        sortedArr2 = insertionSort.sort(sortedArr2);
        //printArr(sortedArr2);
        sortedArr3 = bubbleSort.sort(sortedArr3);
        //printArr(sortedArr3);
        sortedArr4 = mergeSort.sort(sortedArr4);
        //printArr(sortedArr4);
        sortedArr5 = quickSort.sort(sortedArr5);

    }

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + "   ");
        }
    }

}