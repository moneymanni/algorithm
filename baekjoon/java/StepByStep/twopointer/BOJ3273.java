package StepByStep.twopointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {

    private static int n, x;
    private static int count;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        x = Integer.parseInt(br.readLine());

        count = 0;

        int startIdx = 0, endIdx = n - 1;
        while (startIdx < endIdx) {
            int num = arr[startIdx] + arr[endIdx];

            if (num > x) {
                endIdx--;
            } else if (num < x) {
                startIdx++;
            } else {
                count++;
                startIdx++;
            }
        }

        bw.write(count + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
