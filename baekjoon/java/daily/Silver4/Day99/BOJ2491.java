package Silver4.Day99;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int maxIncreasing = 1, maxDecreasing = 1;
        int currIncreasing = 1, currDecreasing = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] >= arr[i-1]) {
                currIncreasing++;
            } else {
                maxIncreasing = Math.max(maxIncreasing, currIncreasing);
                currIncreasing = 1;
            }

            if (arr[i] <= arr[i-1]) {
                currDecreasing++;
            } else {
                maxDecreasing = Math.max(maxDecreasing, currDecreasing);
                currDecreasing = 1;
            }
        }
        maxIncreasing = Math.max(maxIncreasing, currIncreasing);
        maxDecreasing = Math.max(maxDecreasing, currDecreasing);

        int maxLen = Math.max(maxIncreasing, maxDecreasing);
        bw.write(maxLen + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
