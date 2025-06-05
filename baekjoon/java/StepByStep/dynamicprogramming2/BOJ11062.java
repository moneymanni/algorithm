package StepByStep.dynamicprogramming2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11062 {

    private static final int GEUNWOO = 0;
    private static final int MYUNGWOO = 1;

    private static int T, N;
    private static int[] cards;
    private static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            cards = new int[N + 1];
            dp = new int[2][N + 1][N + 1];  // dp[두 차례][남은 카드 중 왼쪽][남은 카드 중 오른쪽]

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < 2; i++) {
                for (int j = 1; j <= N; j++) {
                    for (int k = 1; k <= N; k++) {
                        dp[i][j][k] = -1;
                    }
                }
            }

            bw.write(recursion(GEUNWOO, 1, N) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int recursion(int turn, int start, int end) {
        if (dp[turn][start][end] != -1) {
            return dp[turn][start][end];
        }

        if (start >= end) {
            if (turn == GEUNWOO) {
                return cards[start];
            } else {
                return 0;
            }
        }

        dp[turn][start][end] = 0;

        if (turn == GEUNWOO) {  // 근우 차례는 총 숫자 합이 크도록
            dp[turn][start][end] = Math.max(
                    recursion(turn + 1, start + 1, end) + cards[start],
                    recursion(turn + 1, start, end - 1) + cards[end]
            );
        } else {  // 경우 차례는 뽑았을 때, 양쪽의 합이 작도록
            dp[turn][start][end] = Math.min(
                    recursion(turn - 1, start + 1, end),
                    recursion(turn - 1, start, end - 1)
            );
        }

        return dp[turn][start][end];
    }
}
