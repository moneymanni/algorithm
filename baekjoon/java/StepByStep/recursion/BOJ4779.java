package StepByStep.recursion;

import java.io.*;
import java.util.Arrays;

public class BOJ4779 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;

        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);

            char[] arr = print(N);

            for (Character ch : arr) {
                bw.write(ch + "");
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static char[] print(int num) {
        char[] arr = new char[(int) Math.pow(3, num)];

        Arrays.fill(arr, '-');

        recursion(arr, 0, arr.length - 1);

        return arr;
    }

    private static void recursion(char[] arr, int start, int end) {
        if (end - start <= 1) {
            return;
        }

        int mid1 = start + (end - start) / 3;
        int mid2 = end - (end - start) / 3;

        recursion(arr, start, mid1);
        recursion(arr, mid2, end);

        for (int i = mid1 + 1; i < mid2; i++) {
            arr[i] = ' ';
        }
    }
}
