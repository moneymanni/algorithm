package Day9;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15963 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        bw.write(N == M ? "1" : "0");

        bw.flush();
        bw.close();
    }
}
