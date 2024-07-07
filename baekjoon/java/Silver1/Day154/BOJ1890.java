package Silver1.Day154;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1890 {
    private static int[][] board;
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        board = new int[N + 1][N + 1];
        dp = new long[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        playGame(N);

        bw.write(dp[N][N] + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void playGame(int N) {
        dp[1][1] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (board[i][j] == 0)
                    break;

                int nx = i + board[i][j];
                int ny = j + board[i][j];

                if (nx >= 0 && nx <= N)
                    dp[nx][j] += dp[i][j];
                if (ny >= 0 && ny <= N)
                    dp[i][ny] += dp[i][j];
            }
        }
    }
}
