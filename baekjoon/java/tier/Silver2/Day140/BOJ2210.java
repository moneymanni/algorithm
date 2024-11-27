package Silver2.Day140;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BOJ2210 {
    private static final int N = 5;
    private static final int M = 6;
    private static final int[] dx = new int[]{0, 1, 0, -1};
    private static final int[] dy = new int[]{1, 0, -1, 0};

    private static int[] arr;
    private static int[][] board;
    private static LinkedHashSet<String> set;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        arr = new int[M];
        board = new int[N][N];
        set = new LinkedHashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                DFS(i, j, 0);

        bw.write(set.size() + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int x, int y, int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < M; i++)
                sb.append(arr[i]);

            set.add(sb.toString());

            return;
        }

        for (int k = 0; k < 4; k++) {
            int currX = x + dx[k];
            int currY = y + dy[k];

            if (currX >= 0 && currY >= 0 && currX < N && currY < N) {
                arr[depth] = board[currY][currX];
                DFS(currX, currY, depth + 1);
            }
        }
    }
}
