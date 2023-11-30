package Day36;

import java.io.*;

public class BOJ7567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] bowls = br.readLine().toCharArray();

        int result = 0;
        char previousBowl = '0';
        for (char bowl : bowls) {
            if (previousBowl == bowl)
                result += 5;
            else
                result += 10;
            previousBowl = bowl;
        }
        bw.write(result + "");

        br.close();
        bw.close();
    }
}