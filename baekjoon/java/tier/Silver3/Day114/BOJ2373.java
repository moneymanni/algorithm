package Silver3.Day114;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = Integer.parseInt(st.nextToken());

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(A);

        int cnt = 0;
        int start = 0, end = n-1;
        while (start < end) {
            if (A[start] + A[end] > x) {
                end--;
            } else if (A[start] + A[end] < x) {
                start++;
            } else {
                end--;
                cnt++;
            }
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
