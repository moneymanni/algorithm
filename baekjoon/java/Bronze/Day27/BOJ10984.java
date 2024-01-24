package Day27;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10984 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            double[][] testCase = new double[N][2];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                testCase[j][0] = Double.parseDouble(st.nextToken());
                testCase[j][1] = Double.parseDouble(st.nextToken());
            }

            int total = 0;
            double gpa = 0;
            for (int j = 0; j < N; j++) {
                total += testCase[j][0];
                gpa += testCase[j][0] * testCase[j][1];
            }
            gpa /= total;
            bw.write(String.format("%d %.1f\n", total, gpa));
        }

        br.close();
        bw.close();
    }
}
