package Silver4.Day97;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2578 {
    public static int[] row, column;
    public static int diagonal1, diagonal2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] bingo = new int[5][5];
        for (int i = 0; i < bingo.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < bingo[i].length; j++)
                bingo[i][j] = Integer.parseInt(st.nextToken());
        }

        row = new int[5];
        column = new int[5];
        diagonal1 = 0;
        diagonal2 = 0;

        int cnt = 0, round = 0;
        outer: for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                round++;

                for (int k = 0; k < bingo.length; k++) {
                    for (int l = 0; l < bingo[k].length; l++) {
                        if (bingo[k][l] == num) {
                            bingo[k][l] = -1;

                            if (++row[k] == 5) cnt++;
                            if (++column[l] == 5) cnt++;
                            if (k == l && ++diagonal1 == 5) cnt++;
                            if (k + l == 4 && ++diagonal2 == 5) cnt++;

                            if (cnt >= 3) {
                                break outer;
                            }
                        }
                    }
                }
            }
        }

        bw.write(round + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
