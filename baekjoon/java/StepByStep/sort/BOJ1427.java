package StepByStep.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1427 {

    private static int[] arr, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        arr = new int[input.length()];
        temp = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            arr[i] = input.charAt(i) - '0';
        }

        mergeSort(0, input.length() - 1);

        for (int num : arr) {
            System.out.print(num);
        }
        System.out.println();

        br.close();
    }

    private static void mergeSort(int start, int end) {
        if (end - start < 1) return;

        int mid = start + (end - start) / 2;

        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        int k = start;
        int idx1 = start, idx2 = mid + 1;
        while (idx1 <= mid && idx2 <= end) {
            if (temp[idx1] >= temp[idx2]) {
                arr[k++] = temp[idx1++];
            } else {
                arr[k++] = temp[idx2++];
            }
        }

        while (idx1 <= mid) {
            arr[k++] = temp[idx1++];
        }

        while (idx2 <= end) {
            arr[k++] = temp[idx2++];
        }
    }
}
