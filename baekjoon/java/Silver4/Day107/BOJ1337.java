package Silver4.Day107;

import java.io.*;
import java.util.Arrays;

public class BOJ1337 {
    static final int SIZE = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int startIdx = 0, endIdx = 0;
        int need = SIZE - 1;
        while (endIdx < N) {
            if (arr[endIdx] - arr[startIdx] < SIZE) {
                endIdx++;
                need = Math.min(need, SIZE - (endIdx - startIdx));
            } else {
                startIdx++;
            }
        }

        bw.write(need + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
