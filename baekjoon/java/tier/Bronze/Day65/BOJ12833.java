package Day65;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ12833 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int result = A ^ B;
        while (--C > 0) {
            result = result ^ B;
        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
