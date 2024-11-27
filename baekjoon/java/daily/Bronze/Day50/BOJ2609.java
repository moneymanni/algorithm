package Day50;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bw.write(String.format("%d\n%d", gcd(a, b), lcm(a, b)));

        br.close();
        bw.flush();
        bw.close();
    }

    public static int gcd (int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static int lcm (int a, int b) {
        return a * b / gcd(a, b);
    }
}
