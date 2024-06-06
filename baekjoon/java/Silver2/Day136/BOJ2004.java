package Silver2.Day136;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long cntFive = getFive(N) - getFive(N - M) - getFive(M);
        long cntTwo = getTwo(N) - getTwo(N - M) - getTwo(M);

        long result = Math.min(cntFive, cntTwo);

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static long getFive(long num) {
        long cnt = 0;

        while (num >= 5) {
            cnt += num / 5;
            num /= 5;
        }

        return cnt;
    }

    private static long getTwo(long num) {
        long cnt = 0;

        while (num >= 2) {
            cnt += num / 2;
            num /= 2;
        }

        return cnt;
    }
}
