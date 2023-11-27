package Day34;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String input = st.nextToken();
        int system = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(input, system);
        bw.write(num + "");

        br.close();
        bw.close();
    }
}
