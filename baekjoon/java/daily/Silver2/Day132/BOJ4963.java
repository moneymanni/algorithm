package Silver2.Day132;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ4963 {
    private static int h, w;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    private static int[] dy = new int[]{1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String line;
        while (!(line = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(line);

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        DFS(j, i);
                        cnt++;
                    }
                }
            }

            bw.write(cnt + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int x, int y) {
        visited[y][x] = true;

        for (int i = 0; i < 8; i++) {
            int currX = x + dx[i];
            int currY = y + dy[i];

            if (currX >= 0 && currX < w && currY >= 0 && currY < h) {
                if (!visited[currY][currX] && map[currY][currX] == 1)
                    DFS(currX, currY);
            }
        }
    }
}
