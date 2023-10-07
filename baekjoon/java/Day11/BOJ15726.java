package Day11;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double A = Double.parseDouble(st.nextToken());
        double B = Double.parseDouble(st.nextToken());
        double C = Double.parseDouble(st.nextToken());

        int result = (int) Math.max(A * B / C, A / B * C);
        bw.write(result + "");

        bw.flush();
        bw.close();
    }
}
