package StepByStep.advanced2;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ26069 {

    private static final String CHONGCHONG = "ChongChong";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        set.add(CHONGCHONG);

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            if (set.contains(A) || set.contains(B)) {
                set.add(A);
                set.add(B);
            }
        }

        bw.write(set.size() + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
