package Silver5.Day72;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        int S = 0;

        StringBuilder result = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if (op.equals("all")) {
                S = (1 << 21) - 1;
            } else if (op.equals("empty")) {
                S = 0;
            } else {
                int num = Integer.parseInt(st.nextToken());
                switch (op) {
                    case "add":
                        S |= (1 << num);
                        break;
                    case "remove":
                        S &= ~(1 << num);
                        break;
                    case "check":
                        result.append((S & (1 << num)) != 0 ? 1 : 0).append("\n");
                        break;
                    case "toggle":
                        S ^= (1 << num);
                        break;
                }
            }
        }
        bw.write(result.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
