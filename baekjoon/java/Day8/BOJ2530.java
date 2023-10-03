package Day8;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2530 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(br.readLine().strip());

        if (C + D%60 >= 60) {
            B++;
            C = (C + D%60) % 60;
        } else C = C + D%60;

        if (B + D/60%60 >= 60) {
            A++;
            B = (B + D/60%60) % 60;
        } else B = B + D/60%60;

        if (A + D/60/60 >= 24)
            A = (A + D/60/60) % 24;
        else
            A += D/60/60;

        System.out.printf("%d %d %d\n", A, B, C);
    }
}
