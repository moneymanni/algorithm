package StepByStep.prefixsum;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ25683 {

    private static final char WHITE = 'W';
    private static final char BLACK = 'B';

    private static int N, M, K;
    private static int min, max;
    private static char[][] board;
    private static int[][] black, prefix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N + 1][M + 1];
        black = new int[N + 1][M + 1];  // 맨 왼쪽 위 칸이 검은색인 경우
        prefix = new int[N + 1][M + 1];

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for (int i = 1; i < board.length; i++) {
            String line = br.readLine();
            boolean isBlack = (i % 2 == 1);

            for (int j = 1; j < board[i].length; j++) {
                board[i][j] = line.charAt(j - 1);

                if (!isBlack && board[i][j] == WHITE) {
                    black[i][j] = 1;
                } else if (isBlack && board[i][j] == BLACK) {
                    black[i][j] = 1;
                }
                isBlack = !isBlack;

                prefix[i][j] = black[i][j] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }

        for (int i = K; i < board.length; i++) {
            for (int j = K; j < board[i].length; j++) {
                int value = prefix[i][j] - prefix[i - K][j] - prefix[i][j - K] + prefix[i - K][j - K];
                min = Math.min(min, value);
                max = Math.max(max, value);
            }
        }

        int result = Math.min(min, K * K - max);
        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
