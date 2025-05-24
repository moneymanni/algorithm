package StepByStep.graphandtraversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {

    private static final int EMPTY = -1;
    private static final int UNRIPE = 0;
    private static final int RIPE = 1;
    private static final int[] DX = {0, 1, 0, -1, 0, 0};
    private static final int[] DY = {1, 0, -1, 0, 0, 0};
    private static final int[] DH = {0, 0, 0, 0, 1, -1};

    private static int M, N, H;
    private static int maxCnt = 0;
    private static int[][][] box;
    private static Queue<Tomato> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());

                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());

                    if (box[h][n][m] == RIPE) {
                        queue.add(new Tomato(m, n, h));
                    }
                }
            }
        }

        BFS();

        boolean check = isTomatoRipe();

        if (!check) {
            maxCnt = -1;
        }

        bw.write(maxCnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean isTomatoRipe() {
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == UNRIPE) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static void BFS() {
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();

            maxCnt = Math.max(maxCnt, tomato.cnt);

            for (int i = 0; i < DX.length; i++) {
                int dx = tomato.x + DX[i];
                int dy = tomato.y + DY[i];
                int dh = tomato.h + DH[i];

                if (0 <= dx && dx < M && 0 <= dy && dy < N && 0 <= dh && dh < H) {
                    if (box[dh][dy][dx] == UNRIPE) {
                        queue.add(new Tomato(dx, dy, dh, tomato.cnt + 1));
                        box[dh][dy][dx] = RIPE;
                    }
                }
            }
        }
    }

    private static class Tomato {
        int x;
        int y;
        int h;
        int cnt;

        public Tomato(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.cnt = 0;
        }

        public Tomato(int x, int y, int h, int cnt) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.cnt = cnt;
        }
    }
}
