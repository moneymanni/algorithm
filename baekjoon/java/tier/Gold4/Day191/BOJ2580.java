package Gold4.Day191;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2580 {

    private static final int EMPTY = 0;

    private static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 9; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        sudoku(0, 0);

        br.close();
    }

    private static void sudoku(int row, int col) {
        if (col == 9) {
            sudoku(row + 1, 0);
            return;
        }

        if (row == 9) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++)
                    sb.append(board[i][j]).append(' ');
                sb.append('\n');
            }

            System.out.println(sb);

            System.exit(0);
        }

        if (board[row][col] == EMPTY) {
            for (int i = 1; i <= 9; i++) {
                if (possibility(row, col, i)) {
                    board[row][col] = i;
                    sudoku(row, col + 1);
                }
            }

            board[row][col] = EMPTY;
            return;
        }

        sudoku(row, col + 1);
    }

    private static boolean possibility(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value)
                return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value)
                return false;
        }

        int setRow = (row / 3) * 3;
        int setCol = (col / 3) * 3;

        for (int i = setRow; i < setRow + 3; i++) {
            for (int j = setCol; j < setCol + 3; j++) {
                if (board[i][j] == value)
                    return false;
            }
        }

        return true;
    }
}
