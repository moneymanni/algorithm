package Gold4.Day189;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {

    private static final int SPACE = 0;
    private static final int WALL = 1;
    private static final int VIRUS = 2;
    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    private static int N, M;
    private static int maxSize;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        DFS(0);

        bw.write(maxSize + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int depth) {
        if (depth == 3) {
            int size = BFS();
            maxSize = Math.max(maxSize, size);

            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == SPACE) {
                    map[i][j] = WALL;
                    DFS(depth + 1);
                    map[i][j] = SPACE;
                }
            }
        }
    }

    private static int BFS() {
        int[][] copyMap = new int[N][M];

        for (int i = 0; i < N; i++)
            copyMap[i] = Arrays.copyOf(map[i], map[i].length);

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == VIRUS)
                    queue.offer(new Node(i, j));
            }
        }

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (int i = 0; i < DX.length; i++) {
                int nx = curr.x + DX[i];
                int ny = curr.y + DY[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (copyMap[nx][ny] == SPACE) {
                        copyMap[nx][ny] = VIRUS;
                        queue.offer(new Node(nx, ny));
                    }
                }
            }
        }

        int safeArea = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == SPACE)
                    safeArea++;
            }
        }

        return safeArea;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
