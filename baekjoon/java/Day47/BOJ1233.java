package Day47;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S1 = Integer.parseInt(st.nextToken());
        int S2 = Integer.parseInt(st.nextToken());
        int S3 = Integer.parseInt(st.nextToken());

        int[] cnt = new int[S1 + S2 + S3 + 1];
        for (int i = 1; i <= S1; i++)
            for (int j = 1; j <= S2; j++)
                for (int k = 1; k <= S3; k++)
                    cnt[i+j+k]++;

        int maxIdx = 1;
        for (int i = 2; i < cnt.length; i++)
            if (cnt[maxIdx] < cnt[i])
                maxIdx = i;

        bw.write(maxIdx + "");

        bw.flush();
        br.close();
        bw.close();
    }
}
