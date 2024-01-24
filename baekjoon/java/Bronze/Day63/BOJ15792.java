package Day63;

import java.io.*;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class BOJ15792 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        BigDecimal A = new BigDecimal(st.nextToken());
        BigDecimal B = new BigDecimal(st.nextToken());

        BigDecimal result = A.divide(B, 1000, BigDecimal.ROUND_HALF_UP);
        bw.write(result.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
