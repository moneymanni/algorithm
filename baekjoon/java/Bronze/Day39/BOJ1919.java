package Day39;

import java.io.*;

public class BOJ1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String firstWord = br.readLine();
        String secondWord = br.readLine();

        char[] firstWordChars = firstWord.toCharArray();
        char[] secondWordChars = secondWord.toCharArray();

        int[] firstWordAlphabets = new int[26];
        int[] secondWordAlphabets = new int[26];
        for (int i = 0; i < firstWordChars.length; i++)
            firstWordAlphabets[firstWordChars[i] - 'a']++;
        for (int i = 0; i < secondWordChars.length; i++)
            secondWordAlphabets[secondWordChars[i] - 'a']++;

        int result = 0;
        for (int i = 0; i < firstWordAlphabets.length; i++)
            result += Math.abs(firstWordAlphabets[i] - secondWordAlphabets[i]);

        bw.write(String.format("%d", result));

        br.close();
        bw.close();
    }
}
