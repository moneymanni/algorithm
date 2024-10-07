package Gold5.Day178;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        if (K >= N) {
            bw.write("0");
        } else {
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);

            Integer[] dist = new Integer[N - 1];

            for (int i = 0; i < N - 1; i++)
                dist[i] = arr[i + 1] - arr[i];

            Arrays.sort(dist, Collections.reverseOrder());

            int result = 0;

            for (int i = K - 1; i < N - 1; i++)
                result += dist[i];

            bw.write(result + "");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
