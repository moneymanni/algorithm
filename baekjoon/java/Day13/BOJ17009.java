package Day13;

import java.io.*;

public class BOJ17009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int scoreOfApple = 0;
        int scoreOfBanana = 0;
        for (int i = 3; i > 0; i--)
            scoreOfApple += Integer.parseInt(br.readLine()) * i;
        for (int i = 3; i > 0; i--)
            scoreOfBanana += Integer.parseInt(br.readLine()) * i;

        if (scoreOfApple > scoreOfBanana)
            bw.write("A");
        else if (scoreOfApple == scoreOfBanana)
            bw.write("T");
        else
            bw.write("B");

        br.close();
        bw.close();
    }
}
