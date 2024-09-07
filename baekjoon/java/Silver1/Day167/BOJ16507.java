package Silver1.Day167;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ16507 {
    private static int R, C, Q;
    private static int[][] picture;
    private static int[][] average;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        picture = new int[R + 1][C + 1];
        average = new int[R + 1][C + 1];

        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= C; j++)
                picture[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= R; i++)
            for (int j = 1; j <= C; j++)
                average[i][j] = picture[i][j] + average[i - 1][j] + average[i][j - 1] - average[i - 1][j - 1];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            sb.append((average[r2][c2] - average[r1 - 1][c2] - average[r2][c1 - 1] + average[r1 - 1][c1 - 1]) / ((r2 - r1 + 1) * (c2 - c1 + 1)))
                    .append("\n");
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }
}
