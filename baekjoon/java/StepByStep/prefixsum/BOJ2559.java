package StepByStep.prefixsum;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2559 {

    private static int N, K;
    private static int[] arr, prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        prefixSum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int maxValue = Integer.MIN_VALUE;

        for (int i = K; i <= N; i++) {
            maxValue = Math.max(maxValue, prefixSum[i] - prefixSum[i - K]);
        }

        bw.write(maxValue + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
