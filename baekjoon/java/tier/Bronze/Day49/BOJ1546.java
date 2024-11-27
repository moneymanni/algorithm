package Day49;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            scores[i] = Integer.parseInt(st.nextToken());

        int M = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            M = Math.max(M, scores[i]);
            sum += scores[i];
        }

        double result = sum * 100.0 / M / N;
        bw.write(result + "");

        bw.flush();
        br.close();
        bw.close();
    }
}
