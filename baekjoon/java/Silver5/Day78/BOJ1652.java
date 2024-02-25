package Silver5.Day78;

import java.io.*;

public class BOJ1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[][] room = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++)
                room[i][j] = line.charAt(j);
        }

        int cntRow = 0;
        int cntCol = 0;

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (room[i][j] == '.') {
                    cnt++;

                    if (cnt >= 2 && (j == N - 1 || room[i][j+1] == 'X'))
                        cntRow++;
                } else {
                    cnt = 0;
                }
            }
        }
        for (int j = 0; j < N; j++) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (room[i][j] == '.') {
                    cnt++;

                    if (cnt >= 2 && (i == N - 1 || room[i+1][j] == 'X'))
                        cntCol++;
                } else {
                    cnt = 0;
                }
            }
        }

        bw.write(cntRow + " " + cntCol);

        br.close();
        bw.flush();
        bw.close();
    }
}
