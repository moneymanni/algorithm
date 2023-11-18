package Day27;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ9295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] testCase = new int[T][2];
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            testCase[i][0] = Integer.parseInt(st.nextToken());
            testCase[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < T; i++)
            bw.write(String.format("Case %d: %d\n", i+1, Arrays.stream(testCase[i]).sum()));

        br.close();
        bw.close();
    }
}
