package Gold5.Day173;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int minGap = Integer.MAX_VALUE;
        int[] minValue = new int[]{-1, -1};

        int start = 0, end = N - 1;
        while (start < end) {
            int num = arr[start] + arr[end];

            if (minGap > Math.abs(num)) {
                minGap = Math.abs(num);
                minValue[0] = arr[start];
                minValue[1] = arr[end];

                if (num == 0) break;
            }

            if (num < 0)
                start++;
            else
                end--;
        }

        bw.write(String.format("%d %d", minValue[0], minValue[1]));

        br.close();
        bw.flush();
        bw.close();
    }
}
