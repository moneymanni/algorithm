package Silver1.Day163;

import java.io.*;

public class BOJ17615 {
    private static int N;
    private static int redCnt, blueCnt;
    private static char[] balls;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        balls = new char[N];

        String input = br.readLine();
        for (int i = 0; i < N; i++)
            balls[i] = input.charAt(i);

        redCnt = 0;
        blueCnt = 0;

        for (int i = 0; i < N; i++) {
            if (balls[i] == 'R') redCnt++;
            if (balls[i] == 'B') blueCnt++;
        }

        int minCnt = Integer.MAX_VALUE;

        minCnt = Math.min(minCnt, collectBalls('R', true));
        minCnt = Math.min(minCnt, collectBalls('R', false));
        minCnt = Math.min(minCnt, collectBalls('B', true));
        minCnt = Math.min(minCnt, collectBalls('B', false));

        bw.write(minCnt + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int collectBalls(char color, boolean isIncreasing) {
        int ballCnt = 0;

        if (isIncreasing) {
            for (int i = 0; i < N; i++) {
                if (balls[i] == color) ballCnt++;
                else break;
            }
        } else {
            for (int i = N - 1; i >= 0; i--) {
                if (balls[i] == color) ballCnt++;
                else break;
            }
        }

        if (color == 'R')
            return redCnt - ballCnt;
        else
            return blueCnt - ballCnt;
    }
}
