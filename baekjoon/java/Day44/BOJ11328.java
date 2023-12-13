package Day44;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[][] testCase = new String[N][2];
        for (int i = 0; i < testCase.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < testCase[i].length; j++)
                testCase[i][j] = st.nextToken();
        }

        for (int i = 0; i < testCase.length; i++) {
            String str = testCase[i][0];
            String strfry = testCase[i][1];

            int[] alphabets = new int[26];
            for (int j = 0; j < str.length(); j++)
                alphabets[str.charAt(j) - 'a']++;
            for (int j = 0; j < strfry.length(); j++)
                alphabets[strfry.charAt(j) - 'a']--;

            boolean isStrfry = true;
            for (int alphabet : alphabets) {
                if (alphabet != 0) {
                    isStrfry = false;
                    break;
                }
            }

            if (isStrfry)
                bw.write("Possible\n");
            else
                bw.write("Impossible\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
