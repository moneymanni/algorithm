package Day27;

import java.io.*;

public class BOJ2921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 1 + 2 / 2 + 3 + 4 / 3, 4, 5, 6 / 4, 5, 6, 7, 8
        int result = 0;
        for (int i = 1; i <= N; i++)
            for (int j = i; j <= 2 * i; j++)
                result += j;
        bw.write(result + "");

        br.close();
        bw.close();
    }
}
