package Gold5.Day175;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] block = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < W; i++)
            block[i] = Integer.parseInt(st.nextToken());

        int result = rain(W, block);

        bw.write(Integer.toString(result));

        br.close();
        bw.flush();
        bw.close();
    }

    private static int rain(int W, int[] block) {
        int totalWater = 0;

        for (int i = 1; i < W - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;

            for (int j = 0; j <= i; j++)
                leftMax = Math.max(leftMax, block[j]);

            for (int j = i; j < W; j++)
                rightMax = Math.max(rightMax, block[j]);

            totalWater += Math.min(leftMax, rightMax) - block[i];
        }

        return totalWater;
    }
}
