package Day56;

import java.io.*;

public class BOJ1834 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long sum = 0;
        for (int i = 0; i < N; i++)
            sum += (N + 1L) * i;

        bw.write(sum + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
