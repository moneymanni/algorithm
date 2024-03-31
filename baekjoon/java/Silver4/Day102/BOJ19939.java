package Silver4.Day102;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ19939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int min = K * (K + 1) / 2;
//        int min = sigma(K);

        if (min > N) {
            bw.write("-1");
        } else {
            int result = K - 1;
            N -= min;
            if (N % K != 0)
                result++;
            bw.write(result + "");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static int sigma(int n) {
        int result = 0;

        for (int i = 1; i <= n; i++)
            result += i;

        return result;
    }
}
