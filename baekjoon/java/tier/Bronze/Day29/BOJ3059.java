package Day29;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class BOJ3059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[] testCase = new String[T];
        for (int i = 0; i < T; i++)
            testCase[i] = br.readLine();

        int sumAsciiUpperAlpha = 0;
        for (int i = 'A'; i <= 'Z'; i++)
            sumAsciiUpperAlpha += i;

        for (int i = 0; i < T; i++) {
            int sum = sumAsciiUpperAlpha;
            Set<Character> S = new HashSet<>();
            for (char ch : testCase[i].toCharArray())
                S.add(ch);
            for (char ch : S)
                sum -= ch;
            bw.write(sum + "\n");
        }

        br.close();
        bw.close();
    }
}
