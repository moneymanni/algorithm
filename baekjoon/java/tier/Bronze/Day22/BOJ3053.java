package Day22;

import java.io.*;

public class BOJ3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int R = Integer.parseInt(br.readLine());
        System.out.printf("%.6f\n%.6f", R*R*Math.PI, 2.0*R*R);

        br.close();
    }
}
