package doIt.day253;

import java.io.*;

public class BOJ1947 {

    private static final long MOD = 1_000_000_000L;

    private static int N;
    private static long[] arr = new long[1_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr[1] = 0;
        arr[2] = 1;

        for (int i = 3; i <= N; i++) {
            arr[i] = (i - 1) * (arr[i - 1] + arr[i - 2]) % MOD;
        }

        bw.write(arr[N] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
