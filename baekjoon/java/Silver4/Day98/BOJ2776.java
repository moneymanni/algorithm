package Silver4.Day98;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            Set<Integer> list = new HashSet<>();
            while (N-- > 0)
                list.add(Integer.parseInt(st.nextToken()));

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            while (M-- > 0) {
                if (list.contains(Integer.parseInt(st.nextToken())))
                    sb.append(1).append('\n');
                else
                    sb.append(0).append('\n');
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
