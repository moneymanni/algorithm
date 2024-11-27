package Silver1.Day166;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15954 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        double result = Double.MAX_VALUE;
        double ret = 0;
        
        for (int i = K; i <= N; i++) {
            for (int j = 0; j <= N - i; j++) {
                double m = mean(arr, j, i);
                ret = standardDeviation(arr, m, j, i);
                result = Math.min(result, ret);
            }
        }

        bw.write(String.format("%.11f", result));

        br.close();
        bw.flush();
        bw.close();
    }

    private static double mean(int[] arr, int start, int K) {
        double sum = 0.0;

        for (int i = 0; i < K; i++)
            sum += arr[start + i];

        return sum / K;
    }

    private static double standardDeviation(int[] arr, double m, int start, int K) {
        double sum = 0.0;
        
        for (int i = 0; i < K; i++)
            sum += Math.pow(arr[start + i] - m, 2);
        
        return Math.sqrt(sum / K);
    }
}
