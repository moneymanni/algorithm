package Silver3.Day124;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16956 {
    private static int R, C;
    private static char[][] pasture;
    private static Queue<int[]> queue = new LinkedList<>();
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static boolean check = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        pasture = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                pasture[i][j] = line.charAt(j);
                if (pasture[i][j] == 'W')
                    queue.add(new int[]{i, j});
            }
        }

        BFS();

        StringBuilder sb = new StringBuilder();
        if (check) {
            sb.append(1).append('\n');
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++)
                    sb.append(pasture[i][j]);
                sb.append('\n');
            }
        } else {
            sb.append("0");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void BFS() {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (pasture[nx][ny] == '.')
                        pasture[nx][ny] = 'D';
                    if (pasture[nx][ny] == 'S') {
                        check = false;
                        return;
                    }
                }
            }
        }
    }
}
