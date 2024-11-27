package Day31;

import java.io.*;

public class BOJ10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] fibonacci = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            if (i == 0 || i == 1)
                fibonacci[i] = i;
            else
                fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
        bw.write(fibonacci[N] + "");

        br.close();
        bw.close();
    }
}
