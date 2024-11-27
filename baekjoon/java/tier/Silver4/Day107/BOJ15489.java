package Silver4.Day107;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15489 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int[][] pascal = new int[R + W - 1][R + W - 1];
            for (int i = 0; i < R + W - 1; i++) {
                pascal[i][0] = 1;
                pascal[i][i] = 1;
                for (int j = 1; j < i; j++)
                    pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
            }

            int sum = 0;
            for (int i = 0; i < W; i++)
                for (int j = 0; j <= i; j++)
                    sum += pascal[R-1+i][C-1+j];

            bw.write(sum + "");

            br.close();
            bw.flush();
            bw.close();
        }
}
