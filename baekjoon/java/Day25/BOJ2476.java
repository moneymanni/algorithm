package Day25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dice = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < dice[i].length; j++)
                dice[i][j] = Integer.parseInt(st.nextToken());
            Arrays.sort(dice[i]);
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            int result = 0;
            if (dice[i][0] == dice[i][1] && dice[i][1] == dice[i][2]) {
                result = 10_000 + dice[i][0] * 1_000;
            } else if (dice[i][0] == dice[i][1] || dice[i][1] == dice[i][2]) {
                result = 1_000 + dice[i][1] * 100;
            } else {
                result = dice[i][2] * 100;
            }
            max = Math.max(max, result);
        }
        System.out.println(max);

        br.close();
    }
}
