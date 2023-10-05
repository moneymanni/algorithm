package Day10;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ13866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int min = Math.min(Math.abs((A+B)-(C+D)), Math.min(Math.abs((A+C)-(B+D)), Math.abs((A+D)-(B+C))));
        bw.write(min + "");

        bw.flush();
        bw.close();
    }
}
