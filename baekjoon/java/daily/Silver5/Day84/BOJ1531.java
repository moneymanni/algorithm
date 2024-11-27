package Silver5.Day84;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1531 {
    public static final int SIZE_OF_BIG_PAINTING = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] papers = new int[N][4];
        for (int i = 0; i < papers.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < papers[i].length; j++)
                papers[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] painting = new int[SIZE_OF_BIG_PAINTING+1][SIZE_OF_BIG_PAINTING+1];

        for (int i = 0; i < papers.length; i++) {
            int x1 = papers[i][0];
            int y1 = papers[i][1];
            int x2 = papers[i][2];
            int y2 = papers[i][3];

            for (int j = x1; j <= x2; j++)
                for (int k = y1; k <= y2; k++)
                    painting[j][k]++;
        }

        int cnt = 0;
        for (int i = 1; i <= SIZE_OF_BIG_PAINTING; i++) {
            for (int j = 1; j <= SIZE_OF_BIG_PAINTING; j++) {
                if (painting[i][j] > M)
                    cnt++;
            }
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
