package Day27;

import java.io.*;

public class BOJ4458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            StringBuilder sb = new StringBuilder(line);
            sb.setCharAt(0, line.toUpperCase().charAt(0));
            bw.write(sb.toString() + "\n");
        }

        br.close();
        bw.close();
    }
}
