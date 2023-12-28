package Day54;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int result = rev(X) + rev(Y);
        bw.write(rev(result) + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int rev (int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }
}
