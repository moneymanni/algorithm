package Silver5.Day69;

import java.io.*;
import java.util.Arrays;

public class BOJ4673 {
    public static final int MAX = 10_000;
    public static boolean[] checkSelfNum;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        checkSelfNum = new boolean[MAX + 1];
        Arrays.fill(checkSelfNum, true);

        identifySelfNumberWithinRange(MAX);

        for (int i = 1; i <= MAX; i++) {
            if (checkSelfNum[i])
                bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void identifySelfNumberWithinRange (int max) {
        for (int i = 1; i <= max; i++) {
            if (!checkSelfNum[i])
                continue;

            int num = findSelfNumber(i);
            while (true) {
                if (num > max)
                    break;

                checkSelfNum[num] = false;
                num = findSelfNumber(num);
            }
        }
    }

    public static int findSelfNumber (int num) {
        String numStr = String.valueOf(num);
        int selfNum = num;
        for (int i = 0; i < numStr.length(); i++)
            selfNum += Integer.parseInt(String.valueOf(numStr.charAt(i)));

        return selfNum;
    }
}
