package Silver5.Day77;

import java.io.*;

public class BOJ9625 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());

        int cntA = 1, cntB = 0;

        for (int i = 0; i < K; i++) {
            int tempA = cntB;
            int tempB = cntA + cntB;

            cntA = tempA;
            cntB = tempB;
        }

        bw.write(cntA + " " + cntB);

        br.close();
        bw.flush();
        bw.close();
    }
}
