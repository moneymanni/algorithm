package Day58;

import java.io.*;

public class BOJ10769 {
    public static final String HAPPY = ":-)";
    public static final String SAD = ":-(";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int happyCnt = 0, sadCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ':') {
                String emoticon = i + 3 < str.length() ?str.substring(i, i+3) : str.substring(i, str.length() - 1);

                if (emoticon.equals(HAPPY))
                    happyCnt++;
                else if (emoticon.equals(SAD))
                    sadCnt++;
            }
        }

        if (sadCnt == 0 && happyCnt == 0)
            bw.write("none");
        else if (sadCnt == happyCnt)
            bw.write("unsure");
        else if (sadCnt < happyCnt)
            bw.write("happy");
        else
            bw.write("sad");

        br.close();
        bw.flush();
        bw.close();
    }
}
