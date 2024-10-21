package Gold5.Day182;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt = 0;

        while (Integer.bitCount(N) > K) {
            cnt += N & (-N);
            N += N & (-N);
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
