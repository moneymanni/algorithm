package StepByStep.generator;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ13018 {

    private static final String IMPOSSIBLE = "Impossible";
    private static int n, k;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) {
            bw.write(IMPOSSIBLE);
        } else {
            arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = i + 1;
            }

            int diff = n - k - 1;
            int idx = 1;

            while (diff > 1) {
                swap(arr, idx, idx + 1);
                idx += 2;
                diff -= 2;
            }

            if (diff == 1) {
                swap(arr, 0, n - 1);
            }

            StringBuilder sb = new StringBuilder();

            for (int num : arr) {
                sb.append(num).append(' ');
            }

            bw.write(sb.toString());
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

}
