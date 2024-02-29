package Silver5.Day80;

import java.io.*;

public class BOJ4659 {
    public static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String testCase;
        while (!(testCase = br.readLine()).equals("end")) {
            boolean condition1 = false;  // 조건 1
            boolean condition2 = true;   // 조건 2
            boolean condition3 = true;   // 조건 3

            char prev = ' ';
            int cntVowel = 0, cntConsonant = 0;
            for (int i = 0; i < testCase.length(); i++) {
                char ch = testCase.charAt(i);

                // 조건 1. 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
                boolean isVowel = false;
                for (char vowel : VOWELS) {
                    if (ch == vowel) {
                        isVowel = true;
                        condition1 = true;
                        break;
                    }
                }
                if (isVowel) {
                    cntVowel++;
                    cntConsonant = 0;
                } else {
                    cntConsonant++;
                    cntVowel = 0;
                }

                // 조건 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
                if (cntVowel >= 3 || cntConsonant >= 3) {
                    condition2 = false;
                    break;
                }

                // 조건 3. 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
                if (prev == ch && (prev != 'e' && prev != 'o')) {
                    condition3 = false;
                    break;
                }
                prev = ch;
            }

            if (condition1 && condition2 && condition3)
                bw.write(String.format("<%s> is acceptable.\n", testCase));
            else
                bw.write(String.format("<%s> is not acceptable.\n", testCase));
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
