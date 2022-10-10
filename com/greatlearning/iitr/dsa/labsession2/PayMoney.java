package com.greatlearning.iitr.dsa.labsession2;


import java.util.Scanner;

public class PayMoney {
    public static final String TEXT_RESET = "\u001B[0m",  TEXT_RED = "\u001B[31m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of transaction array:");
        int transSize = sc.nextInt();
        int[] transArr = new int[transSize];

        System.out.println("enter the values of array");
        for (int i = 0; i < transSize; i++) transArr[i] = sc.nextInt();

        System.out.println("enter the total no of targets that needs to be achieved:");
        int targetSize = sc.nextInt();

        for (int i = 0; i < targetSize; i++) {
            System.out.println("enter the value of target");
            int targetVal = sc.nextInt(), sum = 0;
            if (targetVal <= 0) {
                if (targetVal == 0) System.out.println("Target achieved after 0 transactions");
                else System.out.println(TEXT_RED + "Target is not achievable.\n" +
                        "Please enter a valid (positive) target........" + TEXT_RESET);
                continue;
            }
            boolean flag = false;
            for (int j = 0; j < transSize; j++) {
                sum += transArr[j];
                if (sum >= targetVal) {
                    System.out.println("Target achieved after " + (j + 1) + " transactions");
                    flag = true;
                    break;
                }
            }
            if (!flag) System.out.println("Given target is not achieved ");
        }

    }
}