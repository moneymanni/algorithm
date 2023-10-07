package Day11;

import java.io.*;

public class BOJ14470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        int result = 0;
        if (A < 0)
            result += Math.abs(A) * C + D;
        else if (A == 0)
            result += D;

        result += A <= 0 ? B * E : (B - A) * E;

        bw.write(result + "");
        bw.flush();

        br.close();
        bw.close();
    }
}
