package Silver5.Day87;

import java.io.*;

public class BOJ12871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String t = br.readLine();

        int lcmLen = lcm(s.length(), t.length());
        String funcS = s.repeat(lcmLen / s.length());
        String funcT = t.repeat(lcmLen / t.length());

        bw.write(funcS.equals(funcT) ? "1" : "0");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int gcd (int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static int lcm (int a, int b) {
        return a * (b / gcd(a, b));
    }
}
