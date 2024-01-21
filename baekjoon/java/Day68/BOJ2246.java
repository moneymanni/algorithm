package Day68;

import java.io.*;
import java.util.*;

public class BOJ2246 {
    public static final int NUM_OF_INFOS = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] resorts = new int[N][NUM_OF_INFOS];
        for (int i = 0 ;i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < NUM_OF_INFOS; j++)
                resorts[i][j] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            boolean isCandidate = true;
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;

                if (resorts[i][1] >= resorts[j][1] && resorts[i][0] >= resorts[j][0]) {
                    isCandidate = false;
                    break;
                }
            }
            if (isCandidate)
                cnt++;
        }
        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
