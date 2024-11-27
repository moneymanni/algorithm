package Day27;

import java.io.*;

public class BOJ4504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int num;
        while ((num = Integer.parseInt(br.readLine())) != 0) {
            if (num % n == 0)
                bw.write(String.format("%d is a multiple of %d.\n", num, n));
            else
                bw.write(String.format("%d is NOT a multiple of %d.\n", num, n));
        }

        br.close();
        bw.close();
    }
}
