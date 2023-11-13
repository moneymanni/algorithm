package Day25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        int score = 0;
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            int num = A[i];
            switch (num) {
                case 0:
                    cnt = 1;
                    break;
                case 1:
                    score += cnt;
                    cnt++;
                    break;
            }
        }
        System.out.println(score);

        br.close();
    }
}
