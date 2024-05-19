package Silver3.Day121;

import java.io.*;
import java.util.Arrays;

public class BOJ2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] rank = new int[N];
        for (int i = 0; i < N; i++)
            rank[i] = Integer.parseInt(br.readLine());

        Arrays.sort(rank);

        long sum = 0;
        for (int i = 0; i < N; i++)
            sum += Math.abs(rank[i] - (i + 1));

        bw.write(sum + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
