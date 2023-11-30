package Day36;

import java.io.*;

public class BOJ10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while ((line = br.readLine()) != null) {
            int numOfUpperCase = 0;
            int numOfLowerCase = 0;
            int numOfNumbers = 0;
            int numOfSpaces = 0;

            char[] charsLine = line.toCharArray();
            for (char ch : charsLine) {
                if ('a' <= ch && ch <= 'z')
                    numOfLowerCase++;
                else if ('A' <= ch && ch <= 'Z')
                    numOfUpperCase++;
                else if ('0' <= ch && ch <= '9')
                    numOfNumbers++;
                else if (ch == ' ')
                    numOfSpaces++;
            }
            bw.write(String.format("%d %d %d %d\n", numOfLowerCase, numOfUpperCase, numOfNumbers, numOfSpaces));
        }

        br.close();
        bw.close();
    }
}
