package Day41;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2355 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        // 가우스의 법칙
        long max = Math.max(A, B);
        long min = Math.min(A, B);
        long sum = (((max + 1) * max) / 2) - (((min - 1) * min) / 2);

        bw.write(sum + "");

        br.close();
        bw.close();
    }
}
