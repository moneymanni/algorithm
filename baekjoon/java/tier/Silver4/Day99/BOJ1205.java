package Silver4.Day99;

import java.io.*;
import java.util.*;

public class BOJ1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if (N <= 0) {
            bw.write("1");
            bw.close();
            return;
        }

        st = new StringTokenizer(br.readLine());
        Integer[] scores = new Integer[N];
        for (int i = 0; i < N; i++)
            scores[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(scores, Collections.reverseOrder());

        if (scores.length == P && newScore <= scores[scores.length-1]) {
            bw.write("-1");
            bw.close();
            return;
        }

        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (newScore >= scores[i]) {
                rank = i + 1;
                break;
            } else {
                rank++;
            }
        }
        bw.write(rank + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
