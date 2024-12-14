package doit.day207;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {

    private static final int MOVABLE = 1;
    private static final int NON_MOVABLE = 0;
    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();

            for (int j = 1; j <= M; j++) {
                map[i][j] = input.charAt(j - 1) - '0';
            }
        }

        int result = BFS(1, 1, N, M);

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int BFS(int startX, int startY, int endX, int endY) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(startX, startY, 1));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < DX.length; i++) {
                int nx = node.x + DX[i];
                int ny = node.y + DY[i];

                if (nx == endX && ny == endY) {
                    return node.cnt + 1;
                }

                if (nx >= 1 && nx <= N && ny >= 1 && ny <= M) {
                    if (!visited[nx][ny] && map[nx][ny] == MOVABLE) {
                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny, node.cnt + 1));
                    }
                }
            }
        }

        return -1;
    }

    static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
