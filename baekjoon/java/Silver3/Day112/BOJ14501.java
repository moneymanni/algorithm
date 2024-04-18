package Silver3.Day112;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] counsel = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            counsel[i][0] = Integer.parseInt(st.nextToken());
            counsel[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] days = new int[N+1];

        for (int i = 0; i < N; i++) {
            int T = counsel[i][0];
            int P = counsel[i][1];

            if (i + T <= N)
                days[i+T] = Math.max(days[i+T], days[i] + P);
            days[i+1] = Math.max(days[i+1], days[i]);
        }

        bw.write(days[N]+"");

        br.close();
        bw.flush();
        bw.close();
    }
}
