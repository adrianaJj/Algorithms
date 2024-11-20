package org.datastructures.arrays;

import java.io.*;
import java.util.*;

public class YearbookPassing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of students
        System.out.print("Enter the number of students (n): ");
        int n = scanner.nextInt();

        // Input the permutation array
        System.out.println("Enter the permutation array (arr[1..n]): ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Calculate the signatures for each student
        int[] signatures = calculateSignatures(arr);

        // Display the result
        System.out.println("Number of signatures for each student:");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ": " + signatures[i]);
        }

        scanner.close();
    }

    private static int[] calculateSignatures(int[] arr) {
        int n = arr.length;
        int[] signatures = new int[n];

        for (int i = 0; i < n; i++) {
            int currentStudent = i;
            int signaturesCount = 0;
            int[] arrClone = arr.clone();
            while (arrClone[currentStudent] != -1) {
                int nextStudent = arr[currentStudent] - 1;
                arrClone[currentStudent] = -1; // Mark the current yearbook as signed

                currentStudent = nextStudent;
                signaturesCount++;
            }

            signatures[i] = signaturesCount;
        }

        return signatures;
    }
}

