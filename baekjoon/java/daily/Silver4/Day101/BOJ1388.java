package Silver4.Day101;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1388 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] floor = new char[N][M];
        for (int i = 0; i < N; i++)
            floor[i] = br.readLine().toCharArray();

        int total = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (floor[i][j] == '-' && (j == 0 || floor[i][j-1] != '-'))
                    total++;
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (floor[j][i] == '|' && (j == 0 || floor[j-1][i] != '|'))
                    total++;
            }
        }

        bw.write(total + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
