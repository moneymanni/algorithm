package doit.day197;

import java.io.*;

public class BOJ2018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int left = 1, right = 1;
        int sum = 1;
        int cnt = 1;

        while (right != N) {
            if (sum >= N) {
                if (sum == N) cnt++;

                sum -= left++;
            } else {
                sum += ++right;
            }
        }

        bw.write(cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
