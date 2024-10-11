package Gold5.Day179;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] stalagmites = new int[N / 2];  // 석순
        int[] stalactites = new int[N / 2];  // 종유석

        for (int i = 0; i < N / 2; i++) {
            stalagmites[i] = Integer.parseInt(br.readLine());
            stalactites[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(stalagmites);
        Arrays.sort(stalactites);

        int min = N, cnt = 0;

        for (int i = 1; i < H + 1; i++) {
            int sum = binarySearch(0, N / 2, i, stalactites) + binarySearch(0, N / 2, H - i + 1, stalagmites);

            if (min == sum) {
                cnt++;
            } else if (min > sum) {
                min = sum;
                cnt = 1;
            }
        }

        bw.write(min + " " + cnt);

        br.close();
        bw.flush();
        bw.close();
    }

    private static int binarySearch(int left, int right, int h, int[] arr) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= h)
                right = mid;
            else
                left = mid + 1;
        }
        return arr.length - right;
    }
}
