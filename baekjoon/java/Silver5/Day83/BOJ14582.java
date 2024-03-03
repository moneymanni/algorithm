package Silver5.Day83;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14582 {
    public static final int NUM_OF_MATCHES = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] ullim = new int[NUM_OF_MATCHES];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < NUM_OF_MATCHES; i++)
            ullim[i] = Integer.parseInt(st.nextToken());

        int[] startlink = new int[NUM_OF_MATCHES];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < NUM_OF_MATCHES; i++)
            startlink[i] = Integer.parseInt(st.nextToken());

        int scoreUllim = 0, scoreStartlink = 0;
        boolean sufferReversal = false;
        boolean isWinning = false;
        for (int i = 0; i < NUM_OF_MATCHES; i++) {
            scoreUllim += ullim[i];

            if (scoreUllim > scoreStartlink)
                isWinning = true;

            scoreStartlink += startlink[i];

            if (scoreUllim < scoreStartlink && isWinning) {
                sufferReversal = true;
                break;
            }
        }

        bw.write(sufferReversal ? "Yes" : "No");

        br.close();
        bw.flush();
        bw.close();
    }
}
