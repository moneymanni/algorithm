package Silver5.Day81;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        A %= B;

        int result = 0;
        for (int i = 0; i < N; i++) {
            A *= 10;
            result = (int) (A / B);
            A %= B;
        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
