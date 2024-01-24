package Day30;

import java.io.*;

public class BOJ2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int max = 1;
        int add = 6;
        int result = 1;
        while (N > max) {
            max += add;
            add += 6;
            result++;
        }
        bw.write(result + "");

        br.close();
        bw.close();
    }
}
