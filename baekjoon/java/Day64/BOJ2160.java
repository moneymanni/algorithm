package Day64;

import java.io.*;

public class BOJ2160 {
    public static final int ROW = 5;
    public static final int COLUMN = 7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[][][] painting = new char[N][ROW][COLUMN];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < ROW; j++) {
                painting[i][j] = br.readLine().toCharArray();
            }
        }

        int[] idx = new int[2];
        int similarity = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int cnt = 0;
                if (i == j)
                    break;

                for (int x = 0; x < ROW; x++) {
                    for (int y = 0; y < COLUMN; y++) {
                        if (painting[i][x][y] ==  painting[j][x][y])
                            cnt++;
                    }
                }

                if (similarity < cnt) {
                    similarity = cnt;
                    idx[0] = i + 1;
                    idx[1] = j + 1;
                }
            }
        }

        bw.write(String.format("%d %d", idx[0], idx[1]));

        br.close();
        bw.flush();
        bw.close();
    }
}
