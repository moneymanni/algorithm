package Silver4.Day95;

import java.io.*;

public class BOJ1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int len = String.valueOf(N).length();

        long result = (N - (long) Math.pow(10, len - 1) + 1) * len;
        for (int i = 1; i < len; i++)
            result += i * (long) (Math.pow(10, i) - Math.pow(10, i - 1));

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
