package Day11;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ25238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int defense = (int) ((a / 100.0) * (100.0 - b));
        bw.write(defense >= 100 ? "0" : "1");

        bw.flush();
        br.close();
        bw.close();
    }
}
