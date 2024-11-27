package Silver4.Day99;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        if (K > C * R) {
            bw.write("0");
            bw.flush();
            return;
        }

        int[][] seats = new int[R][C];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        boolean[][] visit = new boolean[R][C];

        int cnt = 0, dir = 0;
        int x = R - 1, y = 0;
        while (++cnt != K) {
            visit[x][y] = true;
            int nextX = x + dx[dir];
            int nextY = y + dy[dir];

            if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C || visit[nextX][nextY]) {
                dir = ++dir % 4;
                nextX = x + dx[dir];
                nextY = y + dy[dir];
            }

            x = nextX;
            y = nextY;
        }

        bw.write((y + 1) + " " + (R - x));

        br.close();
        bw.flush();
        bw.close();
    }
}
