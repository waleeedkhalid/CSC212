package me.waleeed.csc212.Recursion;

// Lecture 3 October
public class Recursion {

    // Recursion:
    // 1 - Base Case
    // 2- Recursive Call -> Convergence (state that changed) like n - 1 to stop the loop and not be infinite.

    // n! = { 1 if n = 0 <- Base Case
    //    = { n fact(n-1)! if n >= 1 <- Recusion Case

    public static int recursiveFact(int n) {
        if(n == 0) return 1; // if n == 1 is same thing;
        return n*recursiveFact(n-1);
    }

    public static int iterativeFact(int n) {
        int fact = 1;
        for (int i = 0; i <= n; i++) {
            fact *= i; // fact = fact * i; 3! = 3*2*1;
        }
        return fact;
    }







    // Main  Types of Recursion
    // Linear Recursion
    // Binary Recursion: Like a tree split array to single elements then back

    // Example: Sum(n) = { A[0] if n =1 <- Base Case, Sum(n-1)+A[n-1] if n > 1 <- Recursive Case


    public static int Sum(int[] A, int n) {
        if(n == 1) return A[0];
        return Sum(A, n-1) + A[n-1]; // Symmetric order doesn't matter.
    }

    public static void main(String[] args) {
        int[] arr= new int[]{6,5,3,2,8};
        int sum = BinarySum(arr, 0, 5);
//        System.out.println(sum);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
        int[] arrr = revarray(arr, 1, 3);
        for (int i = 0; i < arrr.length; i++) {
            System.out.print(arrr[i]);
        }
    }


    // Binary Recursion

    public static int BinarySum(int[] A, int i, int n) {
        if(n == 1) return A[i];
        return BinarySum(A, i, (int) Math.ceil(n/2)) + BinarySum(A,i+(int) Math.ceil(n/2), (int) Math.floor(n/2));
    }

    public static int searchEvenindex(int[] a, int n, int k) {
        // n: index, k: value searched
        if(n < 0) return -1; // not found
        if(n % 2 == 0 && a[n] == k) return k;
        return searchEvenindex(a, n - 1, k); // Linear Recursion
        // return searchEvenindex(a, n - 2, k); // another way to search in efficient
    }

    // reverse an array between i and j (most repeated question in interviews)
    public static int[] revarray(int[] a, int i, int j) {
        if (i < j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            return revarray(a, i+1, j-1);
        }
        return a;
    }
}
