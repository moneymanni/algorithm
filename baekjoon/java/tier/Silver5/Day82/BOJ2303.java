package Silver5.Day82;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2303 {
    public static final int NUM_OF_CARD = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] mans = new int[N][NUM_OF_CARD];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < NUM_OF_CARD; j++)
                mans[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[N];
        int maxIdx = -1, max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = chooseThreeNum(mans[i]);
            if (max <= arr[i]) {
                max = arr[i];
                maxIdx = i;
            }
        }

        bw.write((maxIdx + 1) + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int chooseThreeNum (int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    String strNum = String.valueOf(arr[i] + arr[j] + arr[k]);
                    int lastNum = Integer.parseInt(strNum.substring(strNum.length() - 1));
                    max = Math.max(max, lastNum);
                }
            }
        }
        return max;
    }
}
