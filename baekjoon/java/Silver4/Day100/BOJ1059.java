package Silver4.Day100;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] set = new int[L];
        for (int i = 0; i < L; i++)
            set[i] = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        Arrays.sort(set);

        if (Arrays.binarySearch(set, n) >= 0) {
            bw.write("0");
        } else {
            int start = 1, end = 1000;
            for (int i = 0; i < L; i++) {
                if (set[i] < n) {
                    start = set[i] + 1;
                } else if (set[i] > n) {
                    end = set[i] - 1;
                    break;
                }
            }

            int cnt = 0;
            for (int i = start; i <= n; i++)
                for (int j = n; j <= end; j++)
                    if (i != j)
                        cnt++;

//            int cnt = (n - start + 1) * (end - n + 1) - 1;

            bw.write(cnt + "");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
