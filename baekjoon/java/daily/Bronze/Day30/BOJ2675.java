package Day30;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            char[] S = st.nextToken().toCharArray();
            for (char ch : S) {
                for (int j = 0; j < R; j++)
                    bw.write(ch + "");
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }
}
