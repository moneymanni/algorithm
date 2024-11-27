package Silver3.Day123;

import java.io.*;
import java.util.Arrays;

public class BOJ1448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] strawLen = new int[N];
        for (int i = 0; i < N; i++)
            strawLen[i] = Integer.parseInt(br.readLine());

        Arrays.sort(strawLen);

        int len = -1;
        for (int i = N - 1; i > 1; i--) {
            if (strawLen[i] < strawLen[i - 1] + strawLen[i - 2]) {
                len = strawLen[i] + strawLen[i - 1] + strawLen[i - 2];
                break;
            }
        }

        bw.write(len + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
