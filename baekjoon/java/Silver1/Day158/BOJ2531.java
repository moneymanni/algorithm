package Silver1.Day158;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] eating = new int[d + 1];

        eating[c] = 3001;

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int cnt = 1;

        for (int i = 0; i < k; i++) {
            int suchIdx = arr[i];

            if (eating[suchIdx] == 0) cnt++;

            eating[suchIdx]++;
        }

        int max = cnt;

        for (int i = 0; i < N - 1; i++) {
            int startIdx = arr[i];
            int endIdx = arr[(i + k < N) ? i + k : (i + k) % N];

            if (--eating[startIdx] == 0) cnt--;
            if (++eating[endIdx] == 1) cnt++;

            max = Math.max(max, cnt);
        }

        bw.write(String.valueOf(max));

        br.close();
        bw.flush();
        bw.close();
    }
}
