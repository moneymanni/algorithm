package StepByStep.binarysearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {

    private static int N, M;
    private static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            int num = Integer.parseInt(st.nextToken());

            boolean isInArr = binarySearch(num);
            bw.write(isInArr ? "1\n" : "0\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean binarySearch(int targetNum) {
        int start = 0;
        int end = A.length - 1;

        while (start <= end) {
            int midIdx = start + (end - start) / 2;
            int midVal = A[midIdx];

            if (midVal > targetNum) {
                end = midIdx - 1;
            } else if (midVal < targetNum) {
                start = midIdx + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
