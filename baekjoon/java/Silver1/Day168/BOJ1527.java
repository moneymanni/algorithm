package Silver1.Day168;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1527 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int cnt = 0;

        for (int i = A; i <= B; i++)
            if (isGMS(i)) cnt++;

        bw.write(Integer.toString(cnt));

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean isGMS(int num) {
        while (num > 0) {
            int digit = num % 10;

            if (digit != 4 && digit != 7)
                return false;

            num /= 10;
        }

        return true;
    }
}
