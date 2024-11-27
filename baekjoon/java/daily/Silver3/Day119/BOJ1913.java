package Silver3.Day119;

import java.io.*;

public class BOJ1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        int[][] snail = new int[N][N];

        crawlingSnail(snail, N);

        StringBuilder sb = new StringBuilder();
        int[] result = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (snail[i][j] == num) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                }
                sb.append(snail[i][j]).append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString() + String.format("%d %d", result[0], result[1]));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void crawlingSnail (int[][] arr, int N) {
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        int currX = 0, currY = 0;
        arr[currX][currY] = N * N;

        int idx = 0;

        while (idx < 4) {
            int nx = currX + dx[idx];
            int ny = currY + dy[idx];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] == 0) {
                arr[nx][ny] = arr[currX][currY] - 1;

                if (arr[nx][ny] == 1)
                    break;

                currX = nx;
                currY = ny;
            } else {
                idx++;
            }

            if (idx >= 4)
                idx = 0;
        }
    }
}
