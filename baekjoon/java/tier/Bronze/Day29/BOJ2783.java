package Day29;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] riceBallInfo = {Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())};
        int N = Integer.parseInt(br.readLine());
        double[][] testCase = new double[N][2];
        for (int i = 0; i < testCase.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < testCase[i].length; j++)
                testCase[i][j] = Double.parseDouble(st.nextToken());
        }

        double min = riceBallInfo[0] / riceBallInfo[1] * 1000;
        for (int i = 0; i < testCase.length; i++) {
            double X = testCase[i][0];
            double Y = testCase[i][1];  // y그램 당 x원

            double one = (X / Y) * 1000;
            min = Math.min(min, one);
        }
        bw.write(String.format("%.2f", min));

        br.close();
        bw.close();
    }
}
