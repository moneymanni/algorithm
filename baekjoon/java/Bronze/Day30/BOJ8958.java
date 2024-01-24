package Day30;

import java.io.*;

public class BOJ8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[] testCase = new String[T];
        for (int i = 0; i < T; i++)
            testCase[i] = br.readLine().toUpperCase();

        for (int i = 0; i< T; i++) {
            char[] result = testCase[i].toCharArray();
            int cnt = 1;
            int total = 0;
            for (char score : result) {
                if (score == 'O')
                    total += cnt++;
                else
                    cnt = 1;
            }
            bw.write(total + "\n");
        }

        br.close();
        bw.close();
    }
}
