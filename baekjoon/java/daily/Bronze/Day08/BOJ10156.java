package Day8;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(K*N - M <= 0 ? 0 : K*N - M));

        bw.flush();
        bw.close();
    }
}
