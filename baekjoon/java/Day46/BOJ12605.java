package Day46;

import java.io.*;

public class BOJ12605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[][] testCase = new String[N][];
        for (int i = 0; i < N; i++)
            testCase[i] = br.readLine().split(" ");

        for (int i = 0; i < testCase.length; i++) {
            bw.write(String.format("Case #%d: ", i + 1));
            for (int j = testCase[i].length - 1; j >= 0; j--)
                bw.write(testCase[i][j] + " ");
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
