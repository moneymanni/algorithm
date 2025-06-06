package StepByStep.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                min = Math.min(min, getSquaresCnt(board, i, j));
            }
        }

        System.out.println(min);

        br.close();
    }

    private static int getSquaresCnt(char[][] board, int x, int y) {
        int black = 0;
        int white = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if ((i + j) % 2 == 0) {
                    if (board[i][j] != 'B') {
                        black++;
                    }
                    if (board[i][j] != 'W') {
                        white++;
                    }
                } else {
                    if (board[i][j] != 'W') {
                        black++;
                    }
                    if (board[i][j] != 'B') {
                        white++;
                    }
                }
            }
        }

        return Math.min(black, white);
    }
}
