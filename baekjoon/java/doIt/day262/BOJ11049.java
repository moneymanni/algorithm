package doIt.day262;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11049 {

    private static int N;
    private static Matrix[] M;
    private static int[][] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        M = new Matrix[N + 1];
        D = new int[N + 1][N + 1];

        for (int i = 0; i < D.length; i++) {
            for (int j = 0; j < D[i].length; j++) {
                D[i][j] = -1;
            }
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            M[i] = new Matrix(x, y);
        }

        bw.write(excute(1, N) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int excute(int s, int e) {
        int result = Integer.MAX_VALUE;

        if (D[s][e] != -1) {
            return D[s][e];
        }
        if (s == e) {
            return 0;
        }
        if (s + 1 == e) {
            return M[s].y * M[s].x * M[e].x;
        }

        for (int i = s; i < e; i++) {
            result = Math.min(result, M[s].y * M[i].x * M[e].x + excute(s, i) + excute(i + 1, e));
        }

        return D[s][e] = result;
    }

    private static class Matrix {
        int x;
        int y;

        public Matrix(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
