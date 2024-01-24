package Day38;

import java.io.*;

public class BOJ17608 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] heightsOfSticks = new int[N];
        for (int i = 0; i < N; i++)
            heightsOfSticks[i] = Integer.parseInt(br.readLine());

        int maxHeight = 0;
        int cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            int height = heightsOfSticks[i];

            if (height > maxHeight) {
                maxHeight = height;
                cnt++;
            }
        }
        bw.write(cnt + "");

        br.close();
        bw.close();
    }
}
