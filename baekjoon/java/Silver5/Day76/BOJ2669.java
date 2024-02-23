package Silver5.Day76;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] coordinate = new int[4][4];
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++)
                coordinate[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean[][] isEmptyCoordinate = new boolean[100][100];

        for (int i = 0; i < 4; i++) {
            int x1 = coordinate[i][0];
            int y1 = coordinate[i][1];
            int x2 = coordinate[i][2];
            int y2 = coordinate[i][3];

            for (int j = x1; j < x2; j++)
                for (int k = y1; k < y2; k++)
                    isEmptyCoordinate[j][k] = true;
        }

        int sum = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (isEmptyCoordinate[i][j])
                    sum++;
            }
        }

        bw.write(sum + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
