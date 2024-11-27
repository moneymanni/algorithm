package Gold5.Day170;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
    private static final int[] DX = {0, 1, 0, -1, 0, 0};
    private static final int[] DY = {1, 0, -1, 0, 0, 0};
    private static final int[] DH = {0, 0, 0, 0, 1, -1};

    private static int M, N, H;
    private static int maxDays = 0;
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

                    if (box[h][n][m] == 1) {
                        queue.add(new Tomato(m, n, h));
                    }
                }
            }
        }

        getTomatoRipeningDays();

        boolean isTomatoRipe = true;

        outer: for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 0) {
                        isTomatoRipe = false;
                        break outer;
                    }
                }
            }
        }

        bw.write(isTomatoRipe ? String.valueOf(maxDays) : "-1");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void getTomatoRipeningDays() {
        while (!queue.isEmpty()) {
            Tomato tomato = queue.remove();

            maxDays = Math.max(maxDays, tomato.days);

            for (int i = 0; i < DX.length; i++) {
                int nx = tomato.x + DX[i];
                int ny = tomato.y + DY[i];
                int nh = tomato.h + DH[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && nh >= 0 && nh < H) {
                    if (box[nh][ny][nx] == 0) {
                        queue.add(new Tomato(nx, ny, nh, tomato.days + 1));
                        box[nh][ny][nx] = 1;
                    }
                }
            }
        }
    }

    static class Tomato {
        int x;
        int y;
        int h;
        int days;

        public Tomato(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.days = 0;
        }

        public Tomato(int x, int y, int h, int days) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.days = days;
        }
    }
}
