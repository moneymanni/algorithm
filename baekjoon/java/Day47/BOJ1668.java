package Day47;

import java.io.*;

public class BOJ1668 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] trophies = new int[N];
        for (int i = 0; i < N; i++)
            trophies[i] = Integer.parseInt(br.readLine());

        int leftCnt = 1;
        int leftMax = trophies[0];
        for (int i = 1; i < trophies.length; i++) {
            if (leftMax < trophies[i]) {
                leftMax = trophies[i];
                leftCnt++;
            }
        }

        int rightCnt = 1;
        int rightMax = trophies[trophies.length - 1];
        for (int i = trophies.length - 1; i >= 0; i--) {
            if (rightMax < trophies[i]) {
                rightMax = trophies[i];
                rightCnt++;
            }
        }

        bw.write(String.format("%d\n%d", leftCnt, rightCnt));

        bw.flush();
        br.close();
        bw.close();
    }
}
