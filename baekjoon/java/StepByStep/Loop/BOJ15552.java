package StepByStep.Loop;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15552 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bw.write(add(A, B) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int add(int a, int b) {
        return a + b;
    }
}
