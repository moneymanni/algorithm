package Silver5.Day81;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ9237 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] trees = new Integer[N];
        for (int i = 0; i < N; i++)
            trees[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(trees, Collections.reverseOrder());

        int day = 0;
        for (int i = 0; i < N; i++) {
            int curr = i + 1 + trees[i];
            day = Math.max(day, curr);
        }

        bw.write(++day + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
