package Day50;

import java.io.*;

public class BOJ2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] testCase = new int[T][2];
        for (int i = 0; i < testCase.length; i++)
            for (int j = 0; j < testCase[i].length; j++)
                testCase[i][j] = Integer.parseInt(br.readLine());

        int[][] hotel = new int[15][15];
        for (int i = 1; i < hotel.length; i++) {
            hotel[i][1] = 1;
            hotel[0][i] = i;
        }
        for (int i = 1; i < hotel.length; i++) {
            for (int j = 1; j < hotel[i].length; j++) {
                hotel[i][j] = hotel[i][j - 1] + hotel[i - 1][j];
            }
        }

        for (int i = 0; i < testCase.length; i++) {
            int k = testCase[i][0];
            int n = testCase[i][1];
            bw.write(hotel[k][n] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
