package Day56;

import java.io.*;

public class BOJ2810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] seatInfo = br.readLine().toCharArray();

        int cnt = 1;
        boolean isCouple = false;
        for (int i = 0; i < seatInfo.length; i++) {
            if (seatInfo[i] == 'S') {
                cnt++;
            } else if (seatInfo[i] == 'L') {
                if (isCouple) {
                    cnt++;
                    isCouple = false;
                } else {
                    isCouple = true;
                }
            }
        }

        bw.write(Math.min(cnt, N) + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
