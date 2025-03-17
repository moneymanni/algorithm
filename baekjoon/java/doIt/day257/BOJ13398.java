package doIt.day257;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ13398 {

    private static int n;
    private static int[] arr, leftSum, rightSum;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        leftSum = new int[n];
        rightSum = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        leftSum[0] = arr[0];

        int result = leftSum[0];
        
        for (int i = 1; i < n; i++) {
            leftSum[i] = Math.max(arr[i], leftSum[i - 1] + arr[i]);
            result = Math.max(result, leftSum[i]);
        }

        rightSum[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = Math.max(arr[i], rightSum[i + 1] + arr[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            result = Math.max(result, leftSum[i - 1] + rightSum[i + 1]);
        }

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
