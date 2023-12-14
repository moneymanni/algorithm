package Day45;

import java.io.*;

public class BOJ5586 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int cntJOI = 0;
        int cntIOI = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            String word = str.substring(i, i + 3);
            if (word.equals("JOI"))
                cntJOI++;
            else if (word.equals("IOI"))
                cntIOI++;
        }
        bw.write(String.format("%d\n%d", cntJOI, cntIOI));

        bw.flush();
        br.close();
        bw.close();
    }
}
