package Silver1.Day156;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1080 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] matrixA = new int[N][M];
        int[][] matrixB = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < M; j++)
                matrixA[i][j] = input.charAt(j) - '0';
        }

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < M; j++)
                matrixB[i][j] = input.charAt(j) - '0';
        }

        int result = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (matrixA[i][j] == matrixB[i][j])
                    continue;

                result++;

                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        matrixA[x][y] = matrixA[x][y] == 1 ? 0 : 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrixA[i][j] != matrixB[i][j]) {
                    System.out.print(-1);
                    return;
                }
            }
        }

        System.out.print(result);

        br.close();
    }
}
