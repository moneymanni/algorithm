package Gold5.Day178;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ6593 {
    private static final int[] DR = {0, 1, 0, -1, 0, 0};
    private static final int[] DC = {1, 0, -1, 0, 0, 0};
    private static final int[] DL = {0, 0, 0, 0, -1, 1};
    private static int L, R, C;
    private static char[][][] map;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String input;

        while (!(input = br.readLine()).equals("0 0 0")) {
            st = new StringTokenizer(input);
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new char[L][R][C];
            visited = new boolean[L][R][C];

            Point startPoint = null;

            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    input = br.readLine();

                    for (int c = 0; c < C; c++) {
                        map[l][r][c] = input.charAt(c);

                        if (map[l][r][c] == 'S')
                            startPoint = new Point(l, r, c, 0);
                    }
                }

                br.readLine();
            }

            String result = BFS(startPoint);

            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static String BFS(Point startPoint) {
        Queue<Point> queue = new LinkedList<>();

        queue.offer(startPoint);
        visited[startPoint.layer][startPoint.row][startPoint.column] = true;

        while (!queue.isEmpty()) {
            Point currPoint = queue.poll();

            if (map[currPoint.layer][currPoint.row][currPoint.column] == 'E')
                return String.format("Escaped in %d minute(s).", currPoint.time);

            for (int i = 0; i < DR.length; i++) {
                int nl = currPoint.layer + DL[i];
                int nr = currPoint.row + DR[i];
                int nc = currPoint.column + DC[i];

                if (nl >= 0 && nl < L
                        && nr >= 0 && nr < R
                        && nc >= 0 && nc < C) {
                    if (!visited[nl][nr][nc] && map[nl][nr][nc] != '#') {
                        queue.offer(new Point(nl, nr, nc, currPoint.time + 1));
                        visited[nl][nr][nc] = true;
                    }
                }
            }
        }

        return "Trapped!";
    }

    static class Point {
        int layer;
        int row;
        int column;
        int time;

        public Point(int layer, int row, int column, int time) {
            this.layer = layer;
            this.row = row;
            this.column = column;
            this.time = time;
        }
    }
}
