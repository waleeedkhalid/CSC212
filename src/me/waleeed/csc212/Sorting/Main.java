package me.waleeed.csc212.Sorting;

public class Main {
    public static void selectionSort(int[] A, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n - 1 - i; j++) {
                if(A[j] < A[min])
                    min = j;
            }
            // Swap A[i] with A[min]
            int tmp = A[i];
            A[i] = A[min];
            A[min] = tmp;
        }
    }

    public static void bubbleSort(int[] A, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if(A[j] > A[j+1]) {
                    int tmp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = tmp;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr1 = {12, 5, 8, 16, 9, 31};
        int[] arr2 = {12, 5, 8, 16, 9, 31};


        selectionSort(arr1, arr1.length);
        bubbleSort(arr2, arr2.length);

        print(arr1);
        print(arr2);
    }

    public static void print(int[] arr) {
        if(arr.length < 1) return;
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length-1)
                System.out.print(arr[i]);
            else
                System.out.print(arr[i]+",");

        }
        System.out.println("}");
    }
}
