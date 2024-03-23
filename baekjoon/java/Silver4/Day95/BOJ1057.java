package Silver4.Day95;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int round = 0;
        while (num1 != num2) {
            num1 = num1 / 2 + num1 % 2;
            num2 = num2 / 2 + num2 % 2;
            round++;
        }

        bw.write(round + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
