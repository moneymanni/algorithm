package Silver1.Day158;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3184 {
    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{1, 0, -1, 0};

    private static int R, C;
    private static int localWolvesCnt, localSheepCnt;
    private static char[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();

            for (int j = 0; j < C; j++)
                map[i][j] = input.charAt(j);
        }

        int wolvesCnt = 0;
        int sheepCnt = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '#' && !visited[i][j]) {
                    localWolvesCnt = 0;
                    localSheepCnt = 0;

                    DFS(i, j);

                    if (localSheepCnt > localWolvesCnt)
                        sheepCnt += localSheepCnt;
                    else
                        wolvesCnt += localWolvesCnt;
                }
            }
        }

        bw.write(String.format("%d %d", sheepCnt, wolvesCnt));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;

        if (map[x][y] == 'v')
            localWolvesCnt++;
        else if (map[x][y] == 'o')
            localSheepCnt++;

        for (int i = 0; i < DX.length; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                if ((map[nx][ny] == '.' || map[nx][ny] == 'v' || map[nx][ny] == 'o') && !visited[nx][ny]) {
                    DFS(nx, ny);
                }
            }
        }
    }
}
