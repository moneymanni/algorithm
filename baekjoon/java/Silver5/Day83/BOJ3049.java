package Silver5.Day83;

import java.io.*;

public class BOJ3049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long result = combination(N, 4);

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static long combination (int n, int r) {
        long result = 1;
        for (int i = 1; i <= r; i++) {
            result *= n - (i - 1);
            result /= i;
        }
        return result;
    }
}
