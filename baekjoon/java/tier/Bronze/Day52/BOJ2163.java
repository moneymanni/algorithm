package Day52;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // N 개만큼 나눈 값: N - 1 | N개로 나눠진 파편을 M개로 나눈 값: N * (M - 1)
        // N - 1 + N * (M - 1) ==> N * M - 1
        String result = String.valueOf(N * M - 1);
        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }
}
