package Day26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dice = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dice[i][0] = Integer.parseInt(st.nextToken());
            dice[i][1] = Integer.parseInt(st.nextToken());
        }

        int red = 100;
        int blue = 100;
        for (int i = 0; i < n; i++) {
            if (dice[i][0] > dice[i][1])
                blue -= dice[i][0];
            else if (dice[i][0] < dice[i][1])
                red -= dice[i][1];
        }
        System.out.printf("%d\n%d", red, blue);

        br.close();
    }
}
