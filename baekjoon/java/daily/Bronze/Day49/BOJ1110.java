package Day49;

import java.io.*;

public class BOJ1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int num = N;
        int cnt = 0;
        do {
            if (num < 10) {
                num = Integer.parseInt(String.valueOf(num) + num);
            } else {
                int prevNum = num;
                num = Integer.parseInt(String.valueOf(num).substring(0, 1))
                        + Integer.parseInt(String.valueOf(num).substring(1));

                if (num < 10) {
                    num = Integer.parseInt(
                            String.valueOf(prevNum).substring(1)
                                    + num);
                } else {
                    num = Integer.parseInt(
                            String.valueOf(prevNum).substring(1, 2)
                                    + String.valueOf(num).substring(1, 2));
                }
            }
            cnt++;
        } while (num != N);

        bw.write(cnt + "");

        bw.flush();
        br.close();
        bw.close();
    }
}
