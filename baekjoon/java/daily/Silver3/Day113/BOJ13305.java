package Silver3.Day113;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        long[] lensOfRoad = new long[N-1];
        for (int i = 0; i < N-1; i++)
            lensOfRoad[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] stations = new long[N];
        for (int i = 0; i < N; i++)
            stations[i] = Integer.parseInt(st.nextToken());

        long minCost = 0, minPrice = stations[0];
        for (int i = 0; i < N-1; i++) {
            minPrice = Math.min(minPrice, stations[i]);
            minCost += minPrice * lensOfRoad[i];
        }

        bw.write(Long.toString(minCost));

        br.close();
        bw.flush();
        bw.close();
    }
}
