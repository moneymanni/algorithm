package Day48;

import java.io.*;

public class BOJ3062 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] testCase = new int[T];
        for (int i = 0; i < T; i++)
            testCase[i] = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = testCase[i];
            StringBuilder sb = new StringBuilder(String.valueOf(N));
            sb.reverse();
            int reverseN = Integer.parseInt(sb.toString());
            sb.setLength(0);

            int sum = N + reverseN;
            sb.append(sum);
            sb.reverse();
            int reverseSum = Integer.parseInt(sb.toString());

            if (sum == reverseSum)
                bw.write("YES\n");
            else
                bw.write("NO\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
