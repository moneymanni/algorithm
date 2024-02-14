package Silver5.Day75;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] B = new int[M][K];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++)
                B[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] result = new int[N][K];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < K; j++)
                for (int k = 0; k < M; k++)
                    result[i][j] += A[i][k] * B[k][j];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++)
                bw.write(result[i][j] + " ");
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
