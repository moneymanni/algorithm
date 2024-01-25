package Silver5.Day70;

import java.io.*;

public class BOJ1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());

        int crossCnt = 1, prevCntSum = 0;
        while (true) {
            if (X <= prevCntSum + crossCnt) {
                if (crossCnt % 2 == 1) {
                    bw.write(crossCnt - (X - prevCntSum - 1) + "/" + (X - prevCntSum));
                    break;
                } else {
                    bw.write((X - prevCntSum) + "/" + (crossCnt - (X - prevCntSum - 1)));
                    break;
                }
            } else {
                prevCntSum += crossCnt;
                crossCnt++;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
