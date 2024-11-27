package Silver2.Day147;

import java.io.*;
import java.util.Arrays;

public class BOJ10997 {
    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{-1, 0, 1, 0};
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        printStarPattern(N);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++)
                sb.append(map[i][j]);
            sb = new StringBuilder(sb.toString().trim()).append('\n');
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void printStarPattern(int num) {
        if (num == 1) {
            map = new char[1][1];
            map[0][0] = '*';
            return;
        }

        int height = 3 + 4 * (num - 1);
        int weight = 1 + 4 * (num - 1);

        map = new char[height][weight];

        for (int i = 0; i < height; i++)
            Arrays.fill(map[i], ' ');

        int idx = 0;
        int x = 0;
        int y = weight - 1;

        map[x][y] = '*';

        for (int i = 1; i < weight; i++) {
            x += DX[idx];
            y += DY[idx];

            map[x][y] = '*';
        }

        idx++;

        for (int i = 1; i < height; i++) {
            x += DX[idx];
            y += DY[idx];

            map[x][y] = '*';
        }

        idx++;

        while (true) {
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j < weight; j++) {
                    x += DX[idx];
                    y += DY[idx];

                    map[x][y] = '*';
                }

                idx = (idx + 1) % 4;
            }

            if (weight == 3)
                break;

            weight -= 2;
        }
    }
}
