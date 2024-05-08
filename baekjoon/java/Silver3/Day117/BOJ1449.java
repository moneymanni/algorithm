package Silver3.Day117;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] location = new int[N];
        for (int i = 0; i < N; i++)
            location[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(location);

        int cnt = 0;
        int start = 0, end = 0;
        while (true) {
            if (end == N) {
                cnt++;
                break;
            }

            if (location[end] - location[start] < L) {
                end++;
            } else {
                cnt++;
                start = end;
                end = start + 1;
            }
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
