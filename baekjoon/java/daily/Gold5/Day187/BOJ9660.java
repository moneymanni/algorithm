package Gold5.Day187;

import java.io.*;

public class BOJ9660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());

        if (N % 7 == 0 || N % 7 == 2)
            bw.write("CY");
        else
            bw.write("SK");

        br.close();
        bw.flush();
        bw.close();
    }
}
