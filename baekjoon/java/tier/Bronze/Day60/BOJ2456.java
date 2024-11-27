package Day60;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2456 {
    public static final int NUM_OF_CANDIDATES = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] testCase = new int[N][NUM_OF_CANDIDATES];
        for (int i = 0; i < testCase.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < testCase[i].length; j++)
                testCase[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] scores = new int[NUM_OF_CANDIDATES];
        int[][] scoreCnt = new int[NUM_OF_CANDIDATES][NUM_OF_CANDIDATES];
        for (int i = 0; i < testCase.length; i++) {
            for (int j = 0; j < testCase[i].length; j++) {
                int score = testCase[i][j];
                scores[j] += score;
                scoreCnt[j][score - 1]++;
            }
        }

        int maxNum = Arrays.stream(scores).max().getAsInt();

        int president = -1;
        boolean isInvalid = false;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] != maxNum)
                continue;

            if (president == -1) {
                president = i + 1;
                continue;
            }

            int idx = compTo(president - 1, i, scoreCnt);

            if (idx == -1) {
                isInvalid = true;
            } else {
                president = idx + 1;
                isInvalid = false;
            }
        }

        if (isInvalid)
            bw.write(String.format("0 %d", maxNum));
        else
            bw.write(String.format("%d %d", president, maxNum));

        br.close();
        bw.flush();
        bw.close();
    }

    public static int compTo (int a, int b, int[][] scoreCnt) {
        for (int i = scoreCnt[0].length - 1; i >= 0; i--) {
            if (scoreCnt[a][i] > scoreCnt[b][i])
                return a;
            else if (scoreCnt[a][i] < scoreCnt[b][i])
                return b;
        }
        return -1;
    }
}
