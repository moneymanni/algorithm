package Silver4.Day100;

import java.io.*;

public class BOJ2670 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        double[] arr = new double[N];
        for (int i = 0; i < N; i++)
            arr[i] = Double.parseDouble(br.readLine());

//        double max = Double.MIN_VALUE;
//        for (int i = 0; i < N; i++) {
//            double num = arr[i];
//            for (int j = i; j < N; j++) {
//                if (j == i) {
//                    max = Math.max(max, num);
//                    continue;
//                }
//                num *= arr[j];
//                max = Math.max(max, num);
//            }
//        }

        double[] dp = new double[N];
        double max = 0;
        for (int i = 0; i < N; i++) {
            double num = arr[i];

            if (i == 0)
                dp[i] = num;
            else
                dp[i] = Math.max(dp[i-1] * num, num);

            max = Math.max(max, dp[i]);
        }

        bw.write(String.format("%.3f", max));

        br.close();
        bw.flush();
        bw.close();
    }
}
