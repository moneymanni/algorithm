package Silver1.Day149;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2667 {
    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{1, 0, -1, 0};

    private static int N;
    private static int cnt;
    private static ArrayList<Integer> A;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        A = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < N; j++)
                map[i][j] = input.charAt(j) - '0';
        }

        int total = 0;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (map[x][y] == 1 && !visited[x][y]) {
                    cnt = 1;
                    visited[x][y] = true;
                    DFS(x, y);
                    total++;
                    A.add(cnt);
                }
            }
        }

        Collections.sort(A);

        StringBuilder sb = new StringBuilder();

        sb.append(total).append('\n');

        for (Integer i : A)
            sb.append(i).append('\n');

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int x, int y) {
        for (int i = x; i < N; i++) {
            for (int j = y; j < N; j++) {

                for (int k = 0; k < DX.length; k++) {
                    int nx = x + DX[k];
                    int ny = y + DY[k];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        if (map[nx][ny] == 1 && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            cnt++;
                            DFS(nx, ny);
                        }
                    }
                }
            }
        }
    }
}
