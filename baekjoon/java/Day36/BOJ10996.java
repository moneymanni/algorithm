package Day36;

import java.io.*;

public class BOJ10996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 2 * N; i++) {
            if (i % 2 != 0) {
                int numOfStarInRow = N % 2 == 0 ? N / 2 : N / 2 + 1;
                for (int j = 0; j < numOfStarInRow; j++)
                    bw.write("* ");
                bw.write("\n");
            } else {
                int numOfStarInRow = N / 2;
                for (int j = 0; j < numOfStarInRow; j++)
                    bw.write(" *");
                bw.write("\n");
            }
        }

        br.close();
        bw.close();
    }
}
