package StepByStep.divideandconquer;

import java.io.*;

public class BOJ1992 {

    private static int N;
    private static int[][] video;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        video = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();

            for (int j = 1; j <= N; j++) {
                video[i][j] = line.charAt(j - 1) - '0';
            }
        }

        compressWithQuadtree(1, 1, N, N);

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void compressWithQuadtree(int x1, int y1, int x2, int y2) {
        if (isSingleColor(x1, y1, x2, y2)) {
            sb.append(video[x1][y1]);
            return;
        }

        sb.append('(');

        int midX = x1 + (x2 - x1) / 2;
        int midY = y1 + (y2 - y1) / 2;

        compressWithQuadtree(x1, y1, midX, midY);
        compressWithQuadtree(x1, midY + 1, midX, y2);
        compressWithQuadtree(midX + 1, y1, x2, midY);
        compressWithQuadtree(midX + 1, midY + 1, x2, y2);

        sb.append(')');
    }

    private static boolean isSingleColor(int x1, int y1, int x2, int y2) {
        int color = video[x1][y1];

        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                if (video[x][y] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}
