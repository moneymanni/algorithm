package StepByStep.prefixsum;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10986 {

    private static int N, M;
    private static long[] arr, prefixSum, counter;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        prefixSum = new long[N + 1];
        counter = new long[M];
        long cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + arr[i];

            int remainder = (int) (prefixSum[i] % M);

            if (remainder == 0) cnt++;
            counter[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            if (counter[i] > 1) {
                cnt += counter[i] * (counter[i] - 1) / 2;
            }
        }

        bw.write(cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
