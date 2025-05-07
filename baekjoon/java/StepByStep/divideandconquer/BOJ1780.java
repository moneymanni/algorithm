package StepByStep.divideandconquer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1780 {

    private static int N;
    private static int[][] paper;
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        paper = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        countPaperPieces(1, 1, N);

        bw.write(String.format("%d\n%d\n%d\n",
                map.getOrDefault(-1, 0),
                map.getOrDefault(0, 0),
                map.getOrDefault(1, 0)));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void countPaperPieces(int x, int y, int size) {
        if (isSingleNum(x, y, size)) {
            map.put(paper[x][y], map.getOrDefault(paper[x][y], 0) + 1);
            return;
        }

        int newSize = size / 3;

        for (int dx = 0; dx < 3; dx++) {
            for (int dy = 0; dy < 3; dy++) {
                countPaperPieces(x + dx * newSize, y + dy * newSize, newSize);
            }
        }
    }

    private static boolean isSingleNum(int x, int y, int size) {
        int num = paper[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != num) {
                    return false;
                }
            }
        }

        return true;
    }
}
