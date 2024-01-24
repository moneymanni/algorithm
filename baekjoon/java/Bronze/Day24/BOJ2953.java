package Day24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] num = new int[5][4];
        for (int i = 0; i < num.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num[0].length; j++)
                num[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[5];
        for (int i = 0; i < num.length; i++) {
            sum[i] = Arrays.stream(num[i]).sum();
        }

        int max = sum[0];
        int idx = 1;
        for (int i = 1; i < sum.length; i++) {
            if (sum[i] == max) {
                idx = -1;
            } else if (sum[i] > max) {
                max = sum[i];
                idx = i + 1;
            }
        }
        if (idx != -1)
            System.out.printf("%d %d", idx, max);

        br.close();
    }
}
