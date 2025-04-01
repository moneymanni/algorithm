package StepByStep.OneDimensionalArray;

import java.util.Scanner;

public class BOJ2562 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[9];

        int maxValue = 0;
        int maxIdx = -1;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();

            if (maxValue < arr[i]) {
                maxIdx = i + 1;
                maxValue = arr[i];
            }
        }

        System.out.printf("%d\n%d\n", maxValue, maxIdx);
    }
}
