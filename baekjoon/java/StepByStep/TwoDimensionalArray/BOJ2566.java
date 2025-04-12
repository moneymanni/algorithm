package StepByStep.TwoDimensionalArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2566 {

    private static final int VALUE = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] arr = new int[VALUE][VALUE];
        int max = -1;
        int x = -1, y = -1;

        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    x = i + 1;
                    y = j + 1;
                }
            }
        }

        System.out.println(String.format("%d\n%d %d\n", max, x, y));

        br.close();
    }
}
