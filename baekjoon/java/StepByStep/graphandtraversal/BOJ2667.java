package StepByStep.graphandtraversal;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2667 {

    private static final int EMPTY = 0;
    private static final int HOUSE = 1;
    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{1, 0, -1, 0};

    private static int N;
    private static int numComplexes, numHouses;
    private static int[][] map;
    private static boolean[][] visited;
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();

            for (int j = 1; j <= N; j++) {
                map[i][j] = input.charAt(j - 1) - '0';
            }
        }

        numComplexes = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visited[i][j] && map[i][j] == HOUSE) {
                    numComplexes++;

                    numHouses = 0;
                    DFS(i, j);
                    list.add(numHouses);
                }
            }
        }

        Collections.sort(list);

        bw.write(numComplexes + "\n");

        for (int house : list) {
            bw.write(house + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;
        numHouses++;

        for (int k = 0; k < DX.length; k++) {
            int dx = x + DX[k];
            int dy = y + DY[k];

            if (1 <= dx && dx <= N && 1 <= dy && dy <= N) {
                if (!visited[dx][dy] && map[dx][dy] == HOUSE) {
                    DFS(dx, dy);
                }
            }
        }
    }
}
