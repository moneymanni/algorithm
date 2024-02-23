package Silver5.Day76;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ24313 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        if (checkBigO(a1, a0, c, n0))
            bw.write("1");
        else
            bw.write("0");

        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean checkBigO (int a1, int a0, int c, int n0) {
        for (int n = n0; n <= 10_000; n++) {
            if (!(a1 * n + a0 <= c * n))
                return false;
        }
        return true;
    }
}
