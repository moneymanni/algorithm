package Silver5.Day80;

import java.io.*;

public class BOJ15904 {
    public static final String UCPC = "UCPC";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int idx = 0;
        for (int i = 0; i < str.length() && idx < UCPC.length(); i++)
            if (str.charAt(i) == UCPC.charAt(idx))
                idx++;

        if (idx == UCPC.length())
            bw.write("I love UCPC");
        else
            bw.write("I hate UCPC");

        br.close();
        bw.flush();
        bw.close();
    }
}
