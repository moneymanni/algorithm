package StepByStep.graphandtraversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {

    private static final int BLOCKED = 0;
    private static final int PASSABLE = 1;
    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{1, 0, -1, 0};

    private static int N, M;
    private static int minDist;
    private static int[][] maze;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        minDist = 0;
        maze = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < M; j++) {
                maze[i + 1][j + 1] = input.charAt(j) - '0';
            }
        }

        BFS(1, 1);

        bw.write(minDist + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void BFS(int startX, int startY) {
        Queue<Count> queue = new LinkedList<>();

        queue.add(new Count(startX, startY, 1));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Count curr = queue.poll();

            if (curr.x == N && curr.y == M) {
                minDist = curr.dist;
                return;
            }

            for (int k = 0; k < DX.length; k++) {
                int dx = curr.x + DX[k];
                int dy = curr.y + DY[k];

                if (1 <= dx && dx <= N && 1 <= dy && dy <= M) {
                    if (!visited[dx][dy] && maze[dx][dy] == PASSABLE) {
                        queue.add(new Count(dx, dy, curr.dist + 1));
                        visited[dx][dy] = true;
                    }
                }
            }
        }
    }

    private static class Count {
        int x;
        int y;
        int dist;

        public Count(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
