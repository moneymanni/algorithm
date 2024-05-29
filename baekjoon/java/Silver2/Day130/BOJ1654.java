package Silver2.Day130;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] cables = new int[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            cables[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, cables[i]);
        }

        max++;

        long min = 0, mid = 0;

        while (min < max) {
            mid = (max + min) / 2;

            long cnt = 0;

            for (int i = 0; i < cables.length; i++)
                cnt += (cables[i] / mid);

            if (cnt < N)
                max = mid;
            else
                min = mid + 1;
        }

        bw.write(min - 1 + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
