package doIt.day216;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1934 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bw.write((A * B / gcdTopDown(A, B)) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int gcdBottomUp(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    private static int gcdTopDown(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcdTopDown(b, a % b);
    }
}
