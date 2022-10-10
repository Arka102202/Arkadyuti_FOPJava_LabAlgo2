package com.greatlearning.iitr.dsa.labsession2;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CoinChange {

    public static final String TEXT_GREEN = "\u001B[32m", TEXT_RESET = "\u001B[0m";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("enter the size of currency denominations :");
        int size = sc.nextInt();

        int[] denominations = new int[size];
        System.out.println("enter the currency denominations value:");
        for (int i = 0; i < size; i++) denominations[i] = sc.nextInt();

        mergeSort(denominations);

        System.out.println("enter the amount you want to pay:");
        int amount = sc.nextInt();

        if (amount <= 0) {
            if (amount == 0) System.err.println("You don't have to pay any notes for this amount");
            else System.err.println("You have entered a negative value...........\n" +
                    "Sorry. Please try again next time!!!!");
            return;
        }

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = denominations.length - 1; i >= 0; i--) {
            if (denominations[i] > 0) {
                int j = amount / denominations[i];
                amount %= denominations[i];
                if (j > 0) map.put(denominations[i], j);
            }
        }
        if (amount == 0) {
            System.out.println("Your payment approach in order to give min no of notes will be");
            for (int i : map.keySet()) {
                int c = map.get(i);
                if (c > 0) System.out.println(TEXT_GREEN+ i+TEXT_RESET + " : " + c);
            }
        } else System.err.println("you can't make payment with these denominations");
    }

    public static void mergeSort(int[] arr) {
        mergeSort0(arr, 0, arr.length - 1);
    }

    public static void mergeSort0(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) >>> 1;
            mergeSort0(arr, start, mid); // left arr
            mergeSort0(arr, mid + 1, end); // right arr

            int[] lArr = Arrays.copyOfRange(arr, start, mid + 1);
            int[] rArr = Arrays.copyOfRange(arr, mid + 1, end + 1);

            int itr = start, i = 0, j = 0;
            while (i < lArr.length && j < rArr.length) {
                if (lArr[i] < rArr[j]) arr[itr++] = lArr[i++];
                else arr[itr++] = rArr[j++];
            }
            while (i < lArr.length) arr[itr++] = lArr[i++];
            while (j < rArr.length) arr[itr++] = rArr[j++];
        }
    }
}
