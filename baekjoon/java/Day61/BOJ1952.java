package Day61;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int cnt = 0;
        boolean moveHorizontally = true;
        while (true) {
            if (moveHorizontally) {
                if (M != 1) {
                    cnt++;
                    M--;
                } else {
                    cnt++;
                    break;
                }

                moveHorizontally = false;
            } else {
                if (N != 1) {
                    cnt++;
                    N--;
                } else {
                    cnt++;
                    break;
                }

                moveHorizontally = true;
            }
        }

        bw.write((cnt - 1) + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
