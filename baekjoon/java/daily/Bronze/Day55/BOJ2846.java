package Day55;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2846 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            P[i] = Integer.parseInt(st.nextToken());

        int start = P[0];
        int uphill = 0;
        for (int i = 1; i < N; i++) {
            if (P[i - 1] < P[i]) {
                uphill = Math.max(uphill, P[i] - start);
            } else {
                start = P[i];
            }
        }

        bw.write(uphill + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
