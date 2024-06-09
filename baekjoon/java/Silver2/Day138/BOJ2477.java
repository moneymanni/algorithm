package Silver2.Day138;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        int[][] areaInfo = new int[6][2];

        int maxHeightIdx = 0, maxWeightIdx = 0;
        int maxHeightValue = 0, maxWeightValue = 0;

        for (int i = 0; i < areaInfo.length; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            areaInfo[i] = new int[]{dir, len};

            if ((dir == 1 || dir == 2) && maxWeightValue < len) {
                maxWeightIdx = i;
                maxWeightValue = len;
            } else if ((dir == 3 || dir == 4) && maxHeightValue < len) {
                maxHeightIdx = i;
                maxHeightValue = len;
            }
        }

        int right, left;
        int minHeight, minWeight;

        if (maxWeightIdx + 1 == 6) right = 0;
        else right = maxWeightIdx + 1;

        if (maxWeightIdx - 1 == -1) left = 5;
        else left = maxWeightIdx - 1;

        minHeight = Math.abs(areaInfo[right][1] - areaInfo[left][1]);

        if (maxHeightIdx + 1 == 6) right = 0;
        else right = maxHeightIdx + 1;

        if (maxHeightIdx - 1 == -1) left = 5;
        else left = maxHeightIdx - 1;

        minWeight = Math.abs(areaInfo[right][1] - areaInfo[left][1]);

        int bigArea = maxHeightValue * maxWeightValue;
        int smallArea = minHeight * minWeight;

        int result = (bigArea - smallArea) * K;

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
