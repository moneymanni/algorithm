package Day57;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] heightsPeak = new int[N];
        for (int i = 0; i < N; i++)
            heightsPeak[i] = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = i + 1; j < N; j++) {
                if (heightsPeak[i] > heightsPeak[j])
                    cnt++;
                else
                    break;
            }
            max = Math.max(max, cnt);
        }

        bw.write(max + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
