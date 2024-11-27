package Silver4.Day105;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1246 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] P = new int[M];
        for (int i = 0; i < M; i++)
            P[i] = Integer.parseInt(br.readLine());

        Arrays.sort(P);

        int bestPrice = 0, maxProfit = 0;
        for (int i = 0; i < M && i < N; i++) {
            int currProfit = P[M-1-i] * (i + 1);
            if (currProfit > maxProfit) {
                maxProfit = currProfit;
                bestPrice = P[M-1-i];
            }
        }

        bw.write(bestPrice + " "  + maxProfit);

        br.close();
        bw.flush();
        bw.close();
    }
}
