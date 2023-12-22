package Day51;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long result = factorial(N) / (factorial(K) * factorial(N - K));
        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static long factorial (int num) {
        if (num == 0 || num == 1) return 1;
        return num * factorial(num - 1);
    }
}
