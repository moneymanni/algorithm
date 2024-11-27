package Day43;

import java.io.*;

public class BOJ1964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 5 -> 12 (+7(4 + 3(3*1))) -> 22 (+10(4 + 6(3*2))) -> ...
        long result = 5;
        for (int i = 2; i <= N; i++)
            result += 4 + 3L * (i-1);
        result %= 45678;
        bw.write(result + "");

        bw.flush();
        br.close();
        bw.close();
    }
}
