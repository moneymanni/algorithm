package Gold5.Day188;

import java.io.*;

public class BOJ2671 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        String patt = "(100+1+|01)+";

        String result = str.matches(patt) ? "SUBMARINE" : "NOISE";

        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }
}
