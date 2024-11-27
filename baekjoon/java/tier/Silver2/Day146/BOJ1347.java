package Silver2.Day146;

import java.io.*;
import java.util.Arrays;

public class BOJ1347 {
    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int len = Integer.parseInt(br.readLine());
        String input = br.readLine();

        char[][] map = new char[101][101];

        for (int i = 0; i < map.length; i++)
            Arrays.fill(map[i], '#');

        int x = 50, y = 50;
        int minX = 50, maxX = 50;
        int minY = 50, maxY = 50;

        map[x][y] = '.';
        int idx = 1;

        for (int i = 0; i < len; i++) {
            char ch = input.charAt(i);

            switch (ch) {
                case 'R':
                    idx = (idx + 1) % 4;
                    break;
                case 'L':
                    idx = (idx + 3) % 4;
                    break;
                case 'F':
                    x += DX[idx];
                    y += DY[idx];
                    map[x][y] = '.';
                    break;
            }

            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);

            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++)
                sb.append(map[i][j]);
            sb = new StringBuilder(sb.toString().trim()).append('\n');
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }
}
