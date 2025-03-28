package question1;

import java.util.Arrays;

public class SecondMinMax {

    public static void findSecondMinMax(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.out.println("Array must contain at least two elements.");
            return;
        }

        Arrays.sort(arr);

        int secMin = arr[1];
        int secMax = arr[arr.length - 2];

        System.out.println("2nd Min Number: " + secMin);
        System.out.println("2nd Max Number: " + secMax);
    }

    public static void main(String[] args) {
        int[] arr = {21, 7, 29, 4, 1, 67, 41, 9, 57, 88};

        findSecondMinMax(arr);
    }
}