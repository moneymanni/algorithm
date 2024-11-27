package Gold5.Day175;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        String result = mixTwoSolutions(0, arr);

        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }

    private static String mixTwoSolutions(int targetValue, int[] arr) {
        int len = arr.length;

        Arrays.sort(arr);

        int start = 0, end = len - 1;
        int minGap = Integer.MAX_VALUE;
        int[] solutions = new int[2];

        while (start < end) {
            int sum = arr[start] + arr[end];
            int gap = Math.abs(sum);

            if (minGap > gap) {
                minGap = gap;
                solutions[0] = arr[start];
                solutions[1] = arr[end];
            }

            if (sum == targetValue)
                break;

            if (sum < targetValue)
                start++;
            else
                end--;
        }

        return solutions[0] + " " + solutions[1];
    }
}
