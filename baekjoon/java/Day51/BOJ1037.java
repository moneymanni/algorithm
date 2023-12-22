package Day51;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] realDivisor = new int[N];
        for (int i = 0; i < N; i++) {
            realDivisor[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, realDivisor[i]);
            min = Math.min(min, realDivisor[i]);
        }

        long result = (long) max * min;

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
