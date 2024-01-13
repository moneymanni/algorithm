package Day64;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ17224 {
    public static final int EASY_SCORE = 100;
    public static final int DIFFICULT_SCORE = 140;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] sub = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sub[i][0] = Integer.parseInt(st.nextToken());
            sub[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sub, Comparator.comparingInt(a -> a[1]));

        int score = 0;
        for (int i = 0; i < N; i++) {
            if (K == 0)
                break;

            if (sub[i][1] <= L && (1 <= sub[i][1]) && sub[i][1] <= 50) {
                score += DIFFICULT_SCORE;
                sub[i][0] = 0;
                sub[i][1] = 0;
                K--;
            } else {
                break;
            }
        }

        Arrays.sort(sub, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < N; i++) {
            if (K == 0)
                break;

            if ((1 <= sub[i][0] && sub[i][0] <= 50)) {
                if (sub[i][0] <= L) {
                    score += EASY_SCORE;
                    K--;
                } else {
                    break;
                }
            }
        }

        bw.write(score + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
