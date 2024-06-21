package Silver2.Day145;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ5212 {
    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        char[][] afterMap = new char[R][C];
        String input;

        for (int i = 0; i < R; i++) {
            input = br.readLine();

            for (int j = 0; j < C; j++)
                map[i][j] = input.charAt(j);
        }

        int[] startIdx = new int[]{R, C};
        int[] endIdx = new int[]{-1, -1};

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'X') {
                    int cnt = 0;

                    for (int k = 0; k < DX.length; k++) {
                        int nx = i + DX[k];
                        int ny = j + DY[k];

                        if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == '.')
                            cnt++;
                    }

                    if (cnt >= 3){
                        afterMap[i][j] = '.';
                    } else {
                        afterMap[i][j] = 'X';

                        startIdx[0] = Math.min(startIdx[0], i);
                        startIdx[1] = Math.min(startIdx[1], j);
                        endIdx[0] = Math.max(endIdx[0], i);
                        endIdx[1] = Math.max(endIdx[1], j);
                    }
                } else {
                    afterMap[i][j] = map[i][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = startIdx[0]; i <= endIdx[0]; i++) {
            for (int j = startIdx[1]; j <= endIdx[1]; j++)
                sb.append(afterMap[i][j]);
            sb.append('\n');
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }
}
