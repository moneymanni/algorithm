package StepByStep.graphandtraversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {

    private static final int PASSABLE = 0;
    private static final int BLOCKED = 1;
    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{1, 0, -1, 0};

    private static int N, M;
    private static int[][] map;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1][2];

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();

            for (int j = 1; j <= M; j++) {
                map[i][j] = input.charAt(j - 1) - '0';
            }
        }

        int minCnt = BFS(1, 1);

        bw.write(minCnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(x, y, 1, false));

        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            if (curr.x == N && curr.y == M) {
                return curr.cnt;
            }

            for (int i = 0; i < DX.length; i++) {
                int dx = curr.x + DX[i];
                int dy = curr.y + DY[i];

                if (1 <= dx && dx <= N && 1 <= dy && dy <= M) {
                    if (map[dx][dy] == PASSABLE) {
                        if (!curr.destroyed && !visited[dx][dy][0]) {
                            queue.add(new Point(dx, dy, curr.cnt + 1, false));
                            visited[dx][dy][0] = true;
                        } else if (curr.destroyed && !visited[dx][dy][1]) {
                            queue.add(new Point(dx, dy, curr.cnt + 1, true));
                            visited[dx][dy][1] = true;
                        }
                    } else if (map[dx][dy] == BLOCKED) {
                        if (!curr.destroyed) {
                            queue.add(new Point(dx, dy, curr.cnt + 1, true));
                            visited[dx][dy][1] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }

    private static class Point {
        int x;
        int y;
        int cnt;
        boolean destroyed ;

        public Point(int x, int y, int cnt, boolean destroyed ) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.destroyed  = destroyed;
        }
    }
}
