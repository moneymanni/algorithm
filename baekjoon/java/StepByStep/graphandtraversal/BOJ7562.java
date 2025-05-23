package StepByStep.graphandtraversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7562 {

    private static int[] DX = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
    private static int[] DY = new int[]{2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int l = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int[] base = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            st = new StringTokenizer(br.readLine());
            int[] destination = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            int result = BFS(base, destination, l);

            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int BFS(int[] base, int[] destination, int size) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[size][size];

        int x = base[0];
        int y = base[1];

        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] info = queue.remove();
            int cx = info[0];
            int cy = info[1];
            int cnt = info[2];

            if (cx == destination[0] && cy == destination[1]) {
                return cnt;
            }

            for (int i = 0; i < DX.length; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if (nx >= 0 && ny >= 0 && nx < size && ny < size && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, cnt + 1});
                }
            }
        }

        return -1;
    }
}
