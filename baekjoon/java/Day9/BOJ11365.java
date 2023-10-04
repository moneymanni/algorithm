package Day9;

import java.io.*;

public class BOJ11365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String line = br.readLine();
            if (line.equals("END")) break;
            StringBuffer sb = new StringBuffer(line);

            bw.write(sb.reverse().toString() + "\n");
        }
        bw.flush();
        bw.close();
    }
}
