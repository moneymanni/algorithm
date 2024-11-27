package Gold5.Day186;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14728 {
    private static int N, T;
    private static Chapter[] chapters;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        chapters = new Chapter[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            chapters[i] = new Chapter(i, K, S);
        }

        int result = cramming();

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int cramming() {
        dp = new int[N + 1][T + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= T; j++) {
                if (chapters[i].timePerChapter <= j)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - chapters[i].timePerChapter] + chapters[i].chapterScore);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[N][T];
    }

    static class Chapter {
        int chapterNum;
        int timePerChapter;
        int chapterScore;

        public Chapter(int chapterNum, int timePerChapter, int chapterScore) {
            this.chapterNum = chapterNum;
            this.timePerChapter = timePerChapter;
            this.chapterScore = chapterScore;
        }
    }
}
