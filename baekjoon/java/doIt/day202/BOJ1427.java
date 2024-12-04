package doit.day202;

import java.io.*;

public class BOJ1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        int[] arr = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            arr[i] = input.charAt(i) - '0';
        }

        // 선택 정렬
        for (int i = 0; i < arr.length - 1; i++) {
            int idx = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[idx] < arr[j]) {
                    idx = j;
                }
            }

            swap(arr, i, idx);
        }

        for (int i : arr) {
            bw.write(i + "");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
