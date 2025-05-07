package StepByStep.divideandconquer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2630 {

    private static final int WHITE = 0;
    private static final int BLUE = 1;

    private static int N;
    private static int blueCnt, whiteCnt;
    private static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        blueCnt = 0;
        whiteCnt = 0;
        paper = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeColoredPaper(1, 1, N, N);

        bw.write(String.format("%d\n%d\n", whiteCnt, blueCnt));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void makeColoredPaper(int x1, int y1, int x2, int y2) {
        if (isSingleColor(x1, y1, x2, y2)) {
            if (paper[x1][y1] == WHITE) {
                whiteCnt++;
            } else if (paper[x1][y1] == BLUE) {
                blueCnt++;
            }
            return;
        }

        int midX = (x1 + x2) / 2;
        int midY = (y1 + y2) / 2;

        makeColoredPaper(x1, y1, midX, midY);
        makeColoredPaper(x1, midY + 1, midX, y2);
        makeColoredPaper(midX + 1, y1, x2, midY);
        makeColoredPaper(midX + 1, midY + 1, x2, y2);
    }

    private static boolean isSingleColor(int x1, int y1, int x2, int y2) {
        int color = paper[x1][y1];

        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                if (paper[x][y] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}
