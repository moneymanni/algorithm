package Day68;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ25400 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int idx = 1;
        for (int i = 0; i < N; i++) {
            if (idx == A[i]) {
                idx++;
                continue;
            }
            cnt++;
        }
        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
