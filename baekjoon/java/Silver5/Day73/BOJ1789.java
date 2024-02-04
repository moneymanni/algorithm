package Silver5.Day73;

import java.io.*;

public class BOJ1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long S = Long.parseLong(br.readLine());

        long sum = 0;
        long num = 0;
        while (sum <= S) {
            num++;
            sum += num;
        }
        bw.write((num - 1) + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
