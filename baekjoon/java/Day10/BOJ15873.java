package Day10;

import java.io.*;

public class BOJ15873 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        int A, B;
        if (line.length() == 3) {
            if (line.charAt(1) == '0') {
                A = 10;
                B = line.charAt(2) - '0';
            } else {
                A = line.charAt(0) - '0';
                B = 10;
            }
        } else if (line.length() == 4) {
            A = 10;
            B = 10;
        } else {
            A = line.charAt(0) - '0';
            B = line.charAt(1) - '0';
        }

        bw.write(A + B + "");

        bw.flush();
        bw.close();
    }
}
