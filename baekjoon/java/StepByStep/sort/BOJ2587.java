package StepByStep.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2587 {

    private static final int INPUT_NUM = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[INPUT_NUM];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        selectionSort(arr);

        int mean = Arrays.stream(arr).sum() / arr.length;
        int median = arr[2];

        System.out.printf("%d\n%d\n", mean, median);

        br.close();
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int idx = i;

            for (int j = i; j < arr.length; j++) {
                if (arr[idx] < arr[j]) {
                    idx = j;
                }
            }

            if (idx != i) {
                swap(arr, i, idx);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
