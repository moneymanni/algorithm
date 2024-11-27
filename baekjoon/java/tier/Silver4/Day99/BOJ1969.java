package Silver4.Day99;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] dnas = new String[N];
        for (int i = 0; i < N; i++)
            dnas[i] = br.readLine();

        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < M; i++) {
            int[] cnt = new int[4];
            for (String dna : dnas) {
                char ch = dna.charAt(i);
                switch (ch) {
                    case 'A':
                        cnt[0]++;
                        break;
                    case 'C':
                        cnt[1]++;
                        break;
                    case 'G':
                        cnt[2]++;
                        break;
                    case 'T':
                        cnt[3]++;
                        break;
                }
            }

            int maxIdx = 0;
            for (int j = 0; j < 4; j++)
                if (cnt[j] > cnt[maxIdx])
                    maxIdx = j;

            char ch = "ACGT".charAt(maxIdx);
            sb.append(ch);

            sum += N - cnt[maxIdx];
        }
        sb.append('\n').append(sum);

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
