package Gold4.Day191;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {

    private static int N, C;
    private static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];

        for (int i = 0; i < N; i++)
            house[i] = Integer.parseInt(br.readLine());

        Arrays.sort(house);

        int left = 0;
        int right = house[N - 1] - house[0] + 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (getInstallNum(mid) < C)
                right = mid;
            else
                left = mid + 1;
        }

        bw.write((left - 1) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int getInstallNum(int dist) {
        int cnt = 1;
        int prevLoc = house[0];

        for (int i = 1; i < house.length; i++) {
            int loc = house[i];

            if (loc - prevLoc >= dist) {
                cnt++;
                prevLoc = loc;
            }
        }

        return cnt;
    }
}
