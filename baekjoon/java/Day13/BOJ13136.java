package Day13;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ13136 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long row = R%N > 0 ? R/N + 1 : R/N;
        long col = C%N > 0 ? C/N + 1 : C/N;

        bw.write(row * col + "");

        br.close();
        bw.close();
    }
}
