package Silver5.Day84;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ3135 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        int[] frequencies = new int[N];
        for (int i = 0; i < N; i++)
            frequencies[i] = Integer.parseInt(br.readLine());

        int minGap = Math.abs(A - B);
        for (int i = 0; i < N; i++) {
            int gap = Math.abs(B - frequencies[i]);

            minGap = Math.min(minGap, gap);
        }

        int result = minGap == Math.abs(B - A) ? minGap : minGap + 1;
        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
