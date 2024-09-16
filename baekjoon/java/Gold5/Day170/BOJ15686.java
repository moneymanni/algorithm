package Gold5.Day170;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15686 {
    private static int N, M;
    private static int result;
    private static int[][] map;
    private static boolean[] visited;
    private static ArrayList<Point> chicken;
    private static ArrayList<Point> house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        chicken = new ArrayList<>();
        house = new ArrayList<>();
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1)
                    house.add(new Point(i, j));
                else if (map[i][j] == 2)
                    chicken.add(new Point(i, j));
            }
        }

        visited = new boolean[chicken.size()];

        DFS(0, 0);

        bw.write(Integer.toString(result));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int v, int depth) {
        if (depth == M) {
            int res = 0;

            for (int i = 0; i < house.size(); i++) {
                int minDest = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    if (visited[j]) {
                        int dest = Math.abs(house.get(i).x - chicken.get(j).x)
                                + Math.abs(house.get(i).y - chicken.get(j).y);

                        minDest = Math.min(minDest, dest);
                    }
                }

                res += minDest;
            }
            result = Math.min(result, res);

            return;
        }

        for (int i = v; i < chicken.size(); i++) {
            visited[i] = true;
            DFS(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
