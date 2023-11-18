package Day27;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int xA = A % 4 == 0 ? A / 4 : A / 4 + 1;
        int yA = A % 4 == 0 ? 4 : A % 4;
        int xB = B % 4 == 0 ? B / 4 : B / 4 + 1;
        int yB = B % 4 == 0 ? 4 : B % 4;
        int result = Math.abs(xA - xB) + Math.abs(yA - yB);
        bw.write(result + "");

        br.close();
        bw.close();
    }
}
