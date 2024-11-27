package Day29;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] students = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N; i++)
            students[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (i != students[i-1])
                cnt++;
        }
        bw.write(cnt + "");

        br.close();
        bw.close();
    }
}
