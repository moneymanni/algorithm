package Day22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] grid = new int[9][9];
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }

        int max = grid[0][0];
        int[] coordinate = new int[]{1, 2};
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                int num = grid[i][j];
                if (num > max) {
                    max = num;
                    coordinate[0] = i + 1;
                    coordinate[1] = j + 1;
                }
            }

        System.out.printf("%d\n%d %d", max, coordinate[0], coordinate[1]);
        br.close();
    }
}
