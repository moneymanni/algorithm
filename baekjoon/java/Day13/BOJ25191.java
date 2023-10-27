package Day13;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ25191 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int chicken = (A / 2) + B;

        bw.write((Math.min(N, chicken)) + "");

        br.close();
        bw.close();
    }
}
