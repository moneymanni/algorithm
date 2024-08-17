package Silver1.Day162;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String L = st.nextToken();
        String R = st.nextToken();

        int result = 0;

        if (L.length() == R.length()) {
            for (int i = 0; i < L.length() && L.charAt(i) == R.charAt(i); i++) {
                if (L.charAt(i) == '8')
                    result++;
            }
        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
