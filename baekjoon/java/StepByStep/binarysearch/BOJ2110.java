package StepByStep.binarysearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {

    private static int N, C;
    private static int[] houses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C  = Integer.parseInt(st.nextToken());

        houses = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int result = binarySearch();

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int binarySearch() {
        int answer = 0;
        int left = 0;
        int right = houses[N - 1] - houses[0] + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (getInstallNum(mid) < C) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left - 1;
    }

    private static int getInstallNum(int dist) {
        int cnt = 1;
        int prevLoc = houses[0];

        for (int i = 1; i < houses.length; i++) {
            int loc = houses[i];

            if (loc - prevLoc >= dist) {
                cnt++;
                prevLoc = loc;
            }
        }

        return cnt;
    }
}
