package Gold4.Day192;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16234 {

    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    private static int N, L, R;
    private static int[][] A;
    private static boolean[][] visited;
    private static ArrayList<Node> nodeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        while (true) {
            visited = new boolean[N][N];

            boolean isMoved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int sum = BFS(i, j);

                        if (nodeList.size() > 1) {
                            int avg = sum / nodeList.size();

                            for (Node node : nodeList)
                                A[node.x][node.y] = avg;

                            isMoved = true;
                        }
                    }
                }
            }

            if (!isMoved) break;

            cnt++;
        }

        bw.write(cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int BFS(int x, int y) {
        nodeList = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(x, y));
        nodeList.add(new Node(x, y));
        visited[x][y] = true;

        int sum = A[x][y];

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();

            for (int i = 0; i < DX.length; i++) {
                int nx = currNode.x + DX[i];
                int ny = currNode.y + DY[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visited[nx][ny]) {
                        int gap = Math.abs(A[currNode.x][currNode.y] - A[nx][ny]);

                        if (gap >= L && gap <= R) {
                            queue.offer(new Node(nx, ny));
                            nodeList.add(new Node(nx, ny));
                            sum += A[nx][ny];
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }

        return sum;
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
