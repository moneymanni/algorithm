package StepByStep.sort;

import java.io.*;

public class BOJ10989 {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        radixSort(5);

        for (int num : arr) {
            bw.write(num + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void radixSort(int maxSize) {
        int[] output = new int[arr.length];
        int digit = 1;
        int cnt = 0;

        while (cnt != maxSize) {
            int[] bucket = new int[10];

            for (int i = 0; i < arr.length; i++) {
                bucket[(arr[i] / digit) % 10]++;
            }

            for (int i = 1; i < bucket.length; i++) {
                bucket[i] += bucket[i - 1];
            }

            for (int i = arr.length - 1; i >= 0; i--) {
                output[bucket[(arr[i] / digit) % 10] - 1] = arr[i];
                bucket[(arr[i] / digit) % 10]--;
            }

            for (int i = 0; i < arr.length; i++) {
                arr[i] = output[i];
            }

            digit *= 10;
            cnt++;
        }
    }
}
