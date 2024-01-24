package Day45;

import java.io.*;

public class BOJ2495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();

        bw.write(String.format("%d\n%d\n%d",
                countConsecutiveNum(first),
                countConsecutiveNum(second),
                countConsecutiveNum(third)));

        bw.flush();
        br.close();
        bw.close();
    }

    public static int countConsecutiveNum (String str) {
        int maxCnt = 1;
        int cnt = 1;
        int currentNum = Integer.parseInt(String.valueOf(str.charAt(0)));;
        for (int i = 1; i < str.length(); i++) {
            int num = Integer.parseInt(String.valueOf(str.charAt(i)));

            if (currentNum == num) {
                cnt++;
            } else {
                maxCnt = Math.max(maxCnt, cnt);
                currentNum = num;
                cnt = 1;
            }
        }
        maxCnt = Math.max(maxCnt, cnt);

        return maxCnt;
    }
}
