package doIt.day210;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11047 {

    private static int N, K;
    private static int[] coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coin = new int[N];

        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coin);

        int cnt = 0;

        for (int i = coin.length - 1; i >= 0; i--) {
            cnt += K / coin[i];
            K %= coin[i];
        }

        bw.write(cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
