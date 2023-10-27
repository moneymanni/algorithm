package Day13;

import java.io.*;

public class BOJ24883 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char ch = br.readLine().charAt(0);

        if (ch == 'N' || ch == 'n')
            bw.write("Naver D2");
        else
            bw.write("Naver Whale");

        br.close();
        bw.close();
    }
}
