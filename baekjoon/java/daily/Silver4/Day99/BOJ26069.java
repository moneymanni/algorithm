package Silver4.Day99;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Set<String> list = new HashSet<>();
        list.add("ChongChong");
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            if (list.contains(A) || list.contains(B)) {
                list.add(A);
                list.add(B);
            }
        }

        bw.write(list.size() + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
