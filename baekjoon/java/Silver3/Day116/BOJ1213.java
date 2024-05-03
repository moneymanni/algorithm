package Silver3.Day116;

import java.io.*;

public class BOJ1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String engName = br.readLine();

        int[] alphabets = new int[26];
        for (int i = 0; i < engName.length(); i++)
            alphabets[engName.charAt(i) - 'A']++;

        int oddNum = 0;
        for (int i = 0; i < alphabets.length; i++)
            if (alphabets[i] % 2 != 0) oddNum++;

        String result = "";
        StringBuilder sb = new StringBuilder();
        if (oddNum > 1) {
            result = "I'm Sorry Hansoo";
        } else {
            for (int i = 0; i < alphabets.length; i++) {
                for (int j = 0; j < alphabets[i] / 2; j++)
                    sb.append((char) (i + 'A'));
            }
            result += sb.toString();

            String end = sb.reverse().toString();

            sb = new StringBuilder();
            for (int i = 0; i < alphabets.length; i++) {
                if (alphabets[i] % 2 == 1)
                    sb.append((char) (i + 'A'));
            }
            result += sb.toString() + end;
        }
        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }
}
