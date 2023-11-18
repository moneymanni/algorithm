package Day27;

import java.io.*;

public class BOJ2857 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // FBI code는 알파벳 대문자 + 숫자 0~9 + 대시(-) + 최대 10글자로 구성
        String[] fbi = new String[5];
        for (int i = 0; i < fbi.length; i++)
            fbi[i] = br.readLine();

        boolean fbiExist = false;
        for (int i = 0; i < fbi.length; i++) {
            String fbiCode = fbi[i];
            if (fbiCode.contains("FBI")) {
                bw.write((i + 1) + " ");
                fbiExist = true;
            }
        }
        if (!fbiExist)
            bw.write("HE GOT AWAY!");

        br.close();
        bw.close();
    }
}
