package Silver2.Day139;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int[] day = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                day[i] = Integer.parseInt(st.nextToken());

            int max = day[N - 1];
            long sum = 0;

            for (int i = N - 2; i >= 0; i--) {
                int value = day[i];

                if (value > max)
                    max = value;
                else
                    sum += max - value;
            }

            bw.write(sum + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
