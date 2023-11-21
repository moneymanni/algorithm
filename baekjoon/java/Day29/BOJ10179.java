package Day29;

import java.io.*;

public class BOJ10179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        double[] testCase = new double[T];
        for (int i = 0; i < T; i++)
            testCase[i] = Double.parseDouble(br.readLine());

        for (int i = 0; i < T; i++) {
            double product = testCase[i];
            product = (product / 10) * 8;
            bw.write(String.format("$%.2f\n", product));
        }

        br.close();
        bw.close();
    }
}
