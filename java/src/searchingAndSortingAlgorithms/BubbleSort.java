package searchingAndSortingAlgorithms;

import java.sql.SQLOutput;
import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int arr[]) {
        int lastUnsortedIndex = arr.length - 1;
        while (lastUnsortedIndex > 0) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (arr[i] > arr[i + 1])
                    swap(arr, i, i + 1);
            }
            lastUnsortedIndex--;
        }
    }
    

    public static void bubbleSortDescending(int[] arr) {
        int firstUnsortedIndex = 0;
        while(firstUnsortedIndex<arr.length-1){
            for(int i =arr.length-1;i>firstUnsortedIndex;i--){
                if(arr[i]>arr[i-1])
                    swap(arr,i,i-1);
            }
            firstUnsortedIndex++;
        }
    }

    public static void swap(int arr[], int i, int j) {
        if (i == j)
            return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {15, 27, 90, 45, 3, 0, 78, 55, 64, 12, 17};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        bubbleSortDescending(arr);
        System.out.println(Arrays.toString(arr));
    }
}
