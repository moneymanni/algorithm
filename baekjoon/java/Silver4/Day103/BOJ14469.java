package Silver4.Day103;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ14469 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] cows = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cows, Comparator.comparingInt(a -> a[0]));

//        int total = cows[0][0] + cows[0][1];
//        for (int i = 1; i < N; i++) {
//            if (total > cows[i][0])
//                total += cows[i][1];
//            else
//                total = cows[i][0] + cows[i][1];
//        }

        int total = cows[0][0] + cows[0][1];
        for (int i = 1; i < N; i++)
            total = Math.max(total, cows[i][0]) + cows[i][1];

        bw.write(total + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
