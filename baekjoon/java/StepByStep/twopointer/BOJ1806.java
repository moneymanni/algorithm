package StepByStep.twopointer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1806 {

    private static int N, S;
    private static int sum, minLen;
    private static int[] arr, prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        prefixSum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        minLen = Integer.MAX_VALUE;
        int startIdx = 0, endIdx = 0;

        while (startIdx <= endIdx && endIdx <= N) {
            sum = prefixSum[endIdx] - prefixSum[startIdx];

            if (sum >= S) {
                minLen = Math.min(minLen, endIdx - startIdx);
                startIdx++;
            } else {
                endIdx++;
            }
        }

        bw.write((minLen == Integer.MAX_VALUE ? 0 : minLen) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
