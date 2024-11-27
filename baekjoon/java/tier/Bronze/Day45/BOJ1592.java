package Day45;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] person = new int[N+1];
        int idx = 1;
        int cnt = 0;
        while (true) {
            person[idx]++;

            if (person[idx] == M)
                break;

            if (person[idx] % 2 != 0) {
                idx += L;
                if (idx > N)
                    idx -= N;
            } else {
                idx -= L;
                if (idx <= 0)
                    idx += N;
            }
            cnt++;
        }

        bw.write(cnt + "");

        bw.flush();
        br.close();
        bw.close();
    }
}
