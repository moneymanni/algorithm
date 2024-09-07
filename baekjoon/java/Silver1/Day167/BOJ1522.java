package Silver1.Day167;

import java.io.*;

public class BOJ1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        int min = Integer.MAX_VALUE;
        int len = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a')
                len++;
        }

        for (int i = 0; i < input.length(); i++) {
            int cnt = 0;

            for (int j = i; j < i + len; j++) {
                if (input.charAt(j % input.length()) == 'b')
                    cnt++;
            }

            min = Math.min(min, cnt);
        }

        bw.write(Integer.toString(min));

        br.close();
        bw.flush();
        bw.close();
    }
}
