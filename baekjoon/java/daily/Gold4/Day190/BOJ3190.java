package Gold4.Day190;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ3190 {

    private static final int EMPTY = 0;
    private static final int APPLE = 1;
    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    private static int N, K, L;
    private static int[][] map;
    private static LinkedList<Node> snake;
    private static HashMap<Integer, String> hashMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];
        snake = new LinkedList<>();
        hashMap = new HashMap<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            map[x][y] = APPLE;
        }

        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();

            hashMap.put(X, C);
        }

        bw.write(getEndTime() + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int getEndTime() {
        int currX = 0;
        int currY = 0;
        int time = 0;
        int dir = 0;
        snake.add(new Node(0, 0));

        while (true) {
            time++;

            int nextX = currX + DX[dir];
            int nextY = currY + DY[dir];

            if (!check(nextX, nextY))
                break;

            if (map[nextX][nextY] == APPLE) {
                map[nextX][nextY] = EMPTY;
                snake.add(new Node(nextX, nextY));
            } else {
                snake.add(new Node(nextX, nextY));
                snake.remove(0);
            }

            if (hashMap.containsKey(time)) {
                if (hashMap.get(time).equals("D"))
                    dir = (dir + 1) % 4;
                else
                    dir = (dir + 3) % 4;
            }

            currX = nextX;
            currY = nextY;
        }

        return time;
    }

    private static boolean check(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N)
            return false;

        for (Node node : snake) {
            if (x == node.x && y == node.y)
                return false;
        }

        return true;
    }

    static class Spin {
        int time;
        String dir;

        public Spin(int time, String dir) {
            this.time = time;
            this.dir = dir;
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
