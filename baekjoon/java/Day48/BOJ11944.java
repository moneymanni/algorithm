package Day48;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11944 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (sb.length() >= M) {
                sb.setLength(M);
                break;
            }

            sb.append(N);
        }
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
