package Day9;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17388 {
    public static final String SOONGSIL_UNIV = "Soongsil";
    public static final String KOREA_UNIV = "Korea";
    public static final String HANYANG_UNIV = "Hanyang";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        if (S + K + H >= 100)
            bw.write("OK");
        else {
            int[] univ = {S, K, H};
            Arrays.sort(univ);
            if (univ[0] == S)
                bw.write(SOONGSIL_UNIV);
            else if (univ[0] == K)
                bw.write(KOREA_UNIV);
            else
                bw.write(HANYANG_UNIV);
        }

        bw.flush();
        bw.close();
    }
}
