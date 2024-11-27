package Gold5.Day179;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ16926 {
    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    private static int N, M, R;
    private static int minLen;
    private static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        minLen = Math.min(N, M);

        A = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }

        while (R-- > 0)
            rotate();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                sb.append(A[i][j]).append(' ');
            sb.append('\n');
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void rotate() {
        for (int i = 0; i < minLen / 2; i++) {
            int x = i;
            int y = i;

            int temp = A[x][y];
            int idx = 0;

            while (idx < DX.length) {
                int nx = x + DX[idx];
                int ny = y + DY[idx];

                if (nx < N - i && ny < M - i && nx >= i && ny >= i) {
                    A[x][y] = A[nx][ny];
                    x = nx;
                    y = ny;
                } else {
                    idx++;
                }
            }

            A[i + 1][i] = temp;
        }
    }
}
