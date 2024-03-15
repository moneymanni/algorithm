package Silver4.Day89;

import java.io.*;

public class BOJ1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 1; i <= N; i++)
            if (isHanNum(i))
                cnt++;

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean isHanNum (int num) {
        if (num < 100)
            return true;

        int hundreds = num / 100;
        int tens = (num % 100) / 10;
        int units = num % 10;

        return (hundreds - tens) == (tens - units);
    }
}
