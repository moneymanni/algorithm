package doIt.day252;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1256 {

    private static final int MAX = 1_000_000_000;

    private static int N, M, K;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[202][202];

        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                    if (arr[i][j] > MAX) {
                        arr[i][j] = MAX + 1;
                    }
                }
            }
        }

        if (arr[N + M][M] < K) {
            bw.write("-1\n");
        } else {
            while (!(N == 0 && M == 0)) {
                if (arr[N - 1 + M][M] >= K) {
                    bw.write("a");
                    N--;
                } else {
                    bw.write("z");
                    K = K - arr[N - 1 + M][M];
                    M--;
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
