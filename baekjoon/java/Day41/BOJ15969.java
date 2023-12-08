package Day41;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            scores[i] = Integer.parseInt(st.nextToken());

        int max = scores[0];
        int min = scores[0];
        for (int score : scores) {
            max = Math.max(max, score);
            min = Math.min(min, score);
        }
        bw.write(String.format("%d", (max - min)));

        br.close();
        bw.close();
    }
}
