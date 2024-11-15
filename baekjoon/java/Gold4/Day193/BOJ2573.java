package Gold4.Day193;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2573 {

    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int time = 0;

        while ((cnt = countIceberg()) < 2) {
            if (cnt == 0) {
                time = 0;
                break;
            }

            meltIceberg();
            time++;
        }

        bw.write(time + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void meltIceberg() {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    queue.offer(new Node(i, j));
                    check[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();

            int cnt = 0;

            for (int k = 0; k < DX.length; k++) {
                int nx = currNode.x + DX[k];
                int ny = currNode.y + DY[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!check[nx][ny] && map[nx][ny] == 0) {
                        cnt++;
                    }
                }
            }

            if (map[currNode.x][currNode.y] - cnt < 0) {
                map[currNode.x][currNode.y] = 0;
            } else {
                map[currNode.x][currNode.y] -= cnt;
            }
        }
    }

    private static int countIceberg() {
        visited = new boolean[N][M];

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    DFS(i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int k = 0; k < DX.length; k++) {
            int nx = x + DX[k];
            int ny = y + DY[k];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (map[nx][ny] > 0 && !visited[nx][ny]) {
                    DFS(nx, ny);
                }
            }
        }
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
