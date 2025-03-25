package doIt.day264;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14003 {

    private static final int MAX_VALUE = 1_000_000;

    private static int N, maxLen;
    private static int[] A = new int[MAX_VALUE + 1];
    private static int[] B = new int[MAX_VALUE + 1];
    private static int[] D = new int[MAX_VALUE + 1];
    private static int[] answer = new int[MAX_VALUE + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int index;
        B[++maxLen] = A[1];
        D[1] = 1;

        for (int i = 2; i <= N; i++) {
            if (B[maxLen] < A[i]) {
                B[++maxLen] = A[i];
                D[i] = maxLen;
            } else {
                index = binarySearch(1, maxLen, A[i]);
                B[index] = A[i];
                D[i] = index;
            }
        }

        bw.write(maxLen + "\n");

        index = maxLen;
        int x = B[maxLen] + 1;

        for (int i = N; i >= 1; i--) {
            if (D[i] == index && A[i] < x) {
                answer[index--] = A[i];
                x = A[i];
            }
        }

        for (int i = 1; i <= maxLen; i++) {
            bw.write(answer[i] + " ");
        }
        bw.newLine();

        br.close();
        bw.flush();
        bw.close();
    }

    private static int binarySearch(int l, int r, int curr) {
        int mid;

        while (l < r) {
            mid = (l + r) / 2;
            if (B[mid] < curr) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
