package StepByStep.TwoDimensionalArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10798 {

    private static final int MAX_VALUE = 15;
    private static final int INPUT_NUM = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] arr = new char[INPUT_NUM][MAX_VALUE];

        int max = 0;

        for (int i = 0; i < INPUT_NUM; i++) {
            String line = br.readLine();

            max = Math.max(max, line.length());

            for (int j = 0; j < line.length(); j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < max; j++) {
            for (int i = 0; i < INPUT_NUM; i++) {
                if (arr[i][j] == '\0') continue;

                sb.append(arr[i][j]);
            }
        }

        System.out.println(sb);

        br.close();
    }
}
