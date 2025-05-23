package StepByStep.graphandtraversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {

    private static final int EMPTY = -1;
    private static final int UNRIPE = 0;
    private static final int RIPE = 1;
    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{1, 0, -1, 0};

    private static int M, N;
    private static int maxCnt;
    private static int[][] box;
    private static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());

                if (box[i][j] == RIPE) {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }

        BFS();

        boolean check = containsZero();

        bw.write((check ? "-1" : maxCnt) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean containsZero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == UNRIPE) {
                    return true;
                }
            }
        }

        return false;
    }

    private static void BFS() {
        while (!queue.isEmpty()) {
            int[] info = queue.remove();
            int x = info[0];
            int y = info[1];
            int cnt = info[2];

            maxCnt = Math.max(maxCnt, cnt);

            for (int i = 0; i < DX.length; i++) {
                int dx = x + DX[i];
                int dy = y + DY[i];

                if (0 <= dx && dx < N && 0 <= dy && dy < M) {
                    if (box[dx][dy] == UNRIPE) {
                        queue.add(new int[]{dx, dy, cnt + 1});
                        box[dx][dy] = RIPE;
                    }
                }
            }
        }
    }
}
