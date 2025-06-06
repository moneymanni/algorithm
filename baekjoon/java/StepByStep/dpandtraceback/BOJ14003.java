package StepByStep.dpandtraceback;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14003 {

    private static final int MAX_VALUE = 1_000_000;

    private static int N;
    private static int maxLen;
    private static int[] A = new int[MAX_VALUE + 1];
    private static int[] B = new int[MAX_VALUE + 1];  // LIS 배열
    private static int[] D = new int[MAX_VALUE + 1];  // LIS 길이 저장
    private static int[] result = new int[MAX_VALUE + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int idx;
        B[++maxLen] = A[1];
        D[1] = 1;

        for (int i = 2; i <= N; i++) {
            if (B[maxLen] < A[i]) {
                B[++maxLen] = A[i];
                D[i] = maxLen;
            } else {
                idx = binarySearch(1, maxLen, A[i]);
                B[idx] = A[i];
                D[i] = idx;
            }
        }

        bw.write(maxLen + "\n");

        idx = maxLen;
        int x = B[maxLen] + 1;

        for (int i = N; i >= 1; i--) {
            if (D[i] == idx && A[i] < x) {
                result[idx--] = A[i];
                x = A[i];
            }
        }

        for (int i = 1; i <= maxLen; i++) {
            bw.write(result[i] + " ");
        }
        bw.newLine();

        br.close();
        bw.flush();
        bw.close();
    }

    private static int binarySearch(int start, int end, int value) {
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (B[mid] < value) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}
