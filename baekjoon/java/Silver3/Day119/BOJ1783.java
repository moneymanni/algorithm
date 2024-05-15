package Silver3.Day119;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = 0;
        if (N == 1) {
            result = 1;
        } else if (N == 2) {
            result = Math.min(4, (M + 1) / 2);
        } else if (N >= 3) {
            if (M >= 7)
                result = M - 2;
            else
                result = Math.min(4, M);
        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
