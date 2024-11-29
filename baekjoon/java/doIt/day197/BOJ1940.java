package doit.day197;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1940 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0, right = N - 1;
        int cnt = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == M) {
                cnt++;
                right--;
                left++;
            } else if (sum > M) {
                right--;
            } else {
                left++;
            }
        }

        bw.write(cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
