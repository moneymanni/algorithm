package Silver4.Day108;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2980 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int pos = 0, time = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());

            time += D - pos;
            pos = D;

            int gap = time % (R + G);
            if (gap < R)
                time += R - gap;
        }

        time += L - pos;
        bw.write(time + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
