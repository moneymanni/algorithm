package Silver1.Day155;

import java.io.*;

public class BOJ5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int cnt = 0;
        int result = 0;

        for (int i = 1; i < M - 1;) {
            if (S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                cnt++;
                if (cnt == N) {
                    if (S.charAt(i - (cnt * 2 - 1)) == 'I')
                        result++;
                    cnt--;
                }
                i += 2;
            } else {
                cnt = 0;
                i++;
            }
        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
