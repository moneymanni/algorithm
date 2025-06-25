package StepByStep.minimumspanningtree;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ9372 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            while (M-- > 0) {
                br.readLine();
            }

            bw.write((N - 1) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
