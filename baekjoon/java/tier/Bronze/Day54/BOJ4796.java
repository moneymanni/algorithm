package Day54;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        int idx = 1;
        while (!((line = br.readLine()).equals("0 0 0"))) {
            StringTokenizer st = new StringTokenizer(line);

            int L = Integer.parseInt(st.nextToken());  // 사용 일수
            int P = Integer.parseInt(st.nextToken());  // 연속 일수
            int V = Integer.parseInt(st.nextToken());  // 휴가일

            int result = (V / P) * L;
            V = V - (V / P) * P;
            result = V - L > 0 ? result + L : result + V;

            bw.write(String.format("Case %d: %d\n", idx++, result));
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
