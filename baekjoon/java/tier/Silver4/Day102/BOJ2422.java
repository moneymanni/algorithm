package Silver4.Day102;

import java.io.*;
import java.util.*;

public class BOJ2422 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] badComb = new boolean[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            badComb[A][B] = badComb[B][A] = true;
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++)
            for (int j = i + 1; j <= N; j++)
                for (int k = j + 1; k <= N; k++)
                    if (!badComb[i][j] && !badComb[i][k] && !badComb[j][k])
                        cnt++;

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
