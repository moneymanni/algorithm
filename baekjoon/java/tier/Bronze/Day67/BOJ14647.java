package Day67;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14647 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] row = new int[n];
        int[] column = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String value = String.valueOf(board[i][j]);

                for (int k = 0; k < value.length(); k++) {
                    if (value.charAt(k) == '9')
                        row[i]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String value = String.valueOf(board[j][i]);

                for (int k = 0; k < value.length(); k++) {
                    if (value.charAt(k) == '9')
                        column[i]++;
                }
            }
        }

        int sum = Arrays.stream(row).sum();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            max = Math.max(max, row[i]);
        for (int i = 0; i < m; i++)
            max = Math.max(max, column[i]);
        sum -= max;

        bw.write(sum + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
