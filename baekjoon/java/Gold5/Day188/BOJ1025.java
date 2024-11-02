package Gold5.Day188;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1025 {
    private static int N, M;
    private static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < M; j++)
                A[i][j] = input.charAt(j) - '0';
        }

        bw.write(findPerfectSquares() + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int findPerfectSquares() {
        int result = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int di = -N; di < N; di++) {
                    for (int dj = -M; dj < M; dj++) {
                        if (di == 0 && dj == 0)
                            continue;

                        int ni = i;
                        int nj = j;
                        int curr = 0;

                        while (ni >= 0 && ni < N && nj >= 0 && nj < M) {
                            curr *= 10;
                            curr += A[ni][nj];

                            int sqrt  = (int) Math.sqrt((double) curr);

                            if (sqrt * sqrt == curr)
                                result = Math.max(result, curr);

                            ni += di;
                            nj += dj;
                        }
                    }
                }
            }
        }

        return result;
    }
}
