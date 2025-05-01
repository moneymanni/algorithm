package StepByStep.dynamicprogramming1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int max = findLongestBitonic(A);

        bw.write(max + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int findLongestBitonic(int[] arr) {
        int size = arr.length - 1;
        int max = Integer.MIN_VALUE;

        int[] rightDp = new int[size + 1];
        int[] leftDp = new int[size + 1];

        for (int i = 1; i <= size; i++) {
            rightDp[i] = 1;

            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i] && rightDp[i] < rightDp[j] + 1) {
                    rightDp[i] = rightDp[j] + 1;
                }
            }
        }

        for (int i = size; i >= 1; i--) {
            leftDp[i] = 1;

            for (int j = size; j > i; j--) {
                if (arr[j] < arr[i] && leftDp[i] < leftDp[j] + 1) {
                    leftDp[i] = leftDp[j] + 1;
                }
            }
        }

        for (int i = 1; i <= size; i++) {
            max = Math.max(max, rightDp[i] + leftDp[i]);
        }

        return max - 1;
    }
}
