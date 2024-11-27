package Gold5.Day184;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18428 {
    private static final int WALL_NUM = 3;
    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    private static int N;
    private static String result;
    private static char[][] map;
    private static ArrayList<Node> studentList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        result = "NO";
        map = new char[N][N];
        studentList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);

                if (map[i][j] == 'S')
                    studentList.add(new Node(i, j));
            }
        }

        DFS(0);

        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int depth) {
        if (depth == WALL_NUM) {
            if (BFS())
                result = "YES";

            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O';
                    DFS(depth + 1);
                    map[i][j] = 'X';
                }
            }
        }
    }

    private static boolean BFS() {
        Queue<Node> queue = new LinkedList<>();

        char[][] copyMap = new char[N][N];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copyMap[i][j] = map[i][j];

                if (map[i][j] == 'T') {
                    queue.offer(new Node(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();

            for (int i = 0; i < DX.length; i++) {
                int nx = currNode.x + DX[i];
                int ny = currNode.y + DY[i];

                while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (copyMap[nx][ny] != 'O') {
                        visited[nx][ny] = true;
                        nx += DX[i];
                        ny += DY[i];
                    } else {
                        break;
                    }
                }
            }
        }

        return check(visited);
    }

    private static boolean check(boolean[][] visited) {
        for (Node node : studentList) {
            if (visited[node.x][node.y])
                return false;
        }

        return true;
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
