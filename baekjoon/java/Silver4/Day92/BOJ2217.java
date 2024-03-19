package Silver4.Day92;

import java.io.*;
import java.util.Arrays;

public class BOJ2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] ropes = new int[N];
        for (int i = 0; i < N; i++)
            ropes[i] = Integer.parseInt(br.readLine());

        Arrays.sort(ropes);

        int maxWeight = 0;
        for (int i = 0; i < N; i++) {
            int w = ropes[i] * (N - i);
            maxWeight = Math.max(maxWeight, w);
        }

        bw.write(maxWeight + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
