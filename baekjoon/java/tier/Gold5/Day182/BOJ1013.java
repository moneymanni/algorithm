package Gold5.Day182;

import java.io.*;

public class BOJ1013 {
    private static final String REGEX = "(100+1+|01)+";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String str = br.readLine();

            String result = contact(str) ? "YES\n" : "NO\n";

            bw.write(result);
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean contact(String str) {
        return str.matches(REGEX);
    }
}
