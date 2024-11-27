package Gold5.Day180;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int minGap = Integer.MAX_VALUE;
        int start = 0, end = 0;

        while (start <= end && end < N) {
            int gap = arr[end] - arr[start];

            if (gap >= M) {
                start++;
                minGap = Math.min(minGap, gap);
            } else {
                end++;
            }
        }

        bw.write(minGap + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
