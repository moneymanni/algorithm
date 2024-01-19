package Day67;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16433 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        boolean isWhite = (R + C) % 2 == 0;

//        char[][] board = new char[N + 1][N + 1];
//        for (int i = 1; i <= N; i++) {
//            Arrays.fill(board[i], '.');
//        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if ((i + j) % 2 == 0 == isWhite) {
//                    board[i][j] = 'v';
                    sb.append('v');
                } else {
                    sb.append('.');
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
