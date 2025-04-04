package StepByStep.TwoDimensionalArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2563 {

    private static final int WEIGHT = 100;
    private static final int HEIGHT = 100;
    private static final int COLORED_PAPER_SIZE = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[][] isBlack = new boolean[HEIGHT + 1][WEIGHT + 1];

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int i = x; i < x + COLORED_PAPER_SIZE; i++) {
                for (int j = y; j < y + COLORED_PAPER_SIZE; j++) {
                    isBlack[i][j] = true;
                }
            }
        }

        int size = 0;

        for (int i = 1; i <= HEIGHT; i++) {
            for (int j = 1; j <= WEIGHT; j++) {
                if (isBlack[i][j]) size++;
            }
        }

        System.out.println(size);

        br.close();
    }
}
