package Silver2.Day146;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int div = S / K;
        int mod = S % K;
        long max = 1;

        for (int i = 1; i <= K; i++) {
            if (i <= mod)
                max *= (div + 1);
            else
                max *= div;
        }

        bw.write(max + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
