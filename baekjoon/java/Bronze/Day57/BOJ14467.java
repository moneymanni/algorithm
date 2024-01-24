package Day57;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14467 {
    public static final int COWS_NUM = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] obsResult = new int[N][2];
        for (int i = 0; i < obsResult.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < obsResult[i].length; j++)
                obsResult[i][j] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int[] cows = new int[COWS_NUM + 1];
        Arrays.fill(cows, -1);
        for (int i = 0; i < obsResult.length; i++) {
            int cowNum = obsResult[i][0];
            int cowLoc = obsResult[i][1];

            if (cows[cowNum] == -1) {
                cows[cowNum] = cowLoc;
            } else if (cows[cowNum] != cowLoc) {
                cows[cowNum] = cowLoc;
                cnt++;
            }
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
