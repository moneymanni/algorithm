package Gold5.Day169;

import java.io.*;

public class BOJ2447 {
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        printStars(0, 0, N, false);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void printStars(int x, int y, int num, boolean isEmpty) {
        if (isEmpty) {
            for (int i = x; i < x + num; i++)
                for (int j = y; j < y + num; j++)
                    map[i][j] = ' ';
            return;
        }

        if (num == 1) {
            map[x][y] = '*';
            return;
        }

        int size = num / 3;
        int cnt = 0;

        for (int i = x; i < x + num; i += size) {
            for (int j = y; j < y + num; j += size) {
                cnt++;

                if (cnt == 5)
                    printStars(i, j, size, true);
                else
                    printStars(i, j, size, false);
            }
        }
    }
}
