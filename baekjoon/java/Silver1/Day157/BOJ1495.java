package Silver1.Day157;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1495 {
    private static int[] P;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        P = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            P[i] = Integer.parseInt(st.nextToken());

        startPerformance(N, S, M);

        int max = -1;

        for (int i = 0; i <= M; i++)
            if (dp[i] == N)
                max = Math.max(max, i);

        bw.write(max + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void startPerformance(int N, int S, int M) {
        dp = new int[M + 1];

        Arrays.fill(dp, -1);

        dp[S] = 0;

        for (int i = 0; i < N; i++) {
            int num = P[i];
            ArrayList<Integer> list = new ArrayList<>();

            for (int j = 0; j <= M; j++) {
                if (dp[j] == i) {
                    int volume1 = j + num;
                    int volume2 = j - num;

                    if (0 <= volume1 && volume1 <= M)
                        list.add(volume1);
                    if (0 <= volume2 && volume2 <= M)
                        list.add(volume2);
                }
            }

            for (int n : list)
                dp[n] = i + 1;
        }
    }
}
