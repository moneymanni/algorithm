package Silver4.Day93;

import java.io.*;
import java.util.Arrays;

public class BOJ10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String strNum = br.readLine();

        int[] digits = new int[strNum.length()];
        int sum =0;
        boolean hasZero = false;
        for (int i = 0; i < strNum.length(); i++) {
            digits[i] = strNum.charAt(i) - '0';
            sum += digits[i];
            if (digits[i] == 0)
                hasZero = true;
        }

        if (!hasZero || sum % 3 != 0) {
            bw.write("-1");
        } else {
            Arrays.sort(digits);

            for (int i = digits.length - 1; i >= 0; i--)
                bw.write(digits[i] + "");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
