package StepByStep.twopointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {

    private static int N;
    private static long x, y;
    private static long min;
    private static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        x = -1L;
        y = -1L;
        min = Integer.MAX_VALUE;
        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int minIdx = 0, maxIdx = N - 1;
        while (minIdx < maxIdx) {
            long num = arr[minIdx] + arr[maxIdx];

            if (Math.abs(num) < min) {
                x = arr[minIdx];
                y = arr[maxIdx];
                min = Math.abs(num);

                if (num == 0) break;
            }

            if (num >= 0) {
                maxIdx--;
            } else {
                minIdx++;
            }
        }

        bw.write(String.format("%d %d\n", x, y));

        br.close();
        bw.flush();
        bw.close();
    }
}
