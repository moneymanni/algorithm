package Silver1.Day161;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int maxLen = 0;
        int start = 0, end = 0;
        int[] cnt = new int[100_001];

        while (end < N) {
            while (end < N && cnt[arr[end]] + 1 <= K)
                cnt[arr[end++]]++;

            maxLen = Math.max(maxLen, end - start);

            cnt[arr[start++]]--;
        }

        bw.write(maxLen + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
