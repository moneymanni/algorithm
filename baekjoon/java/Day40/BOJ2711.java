package Day40;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2711 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[][] testCase = new String[T][2];
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            testCase[i][0] = st.nextToken();
            testCase[i][1] = st.nextToken();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int typo = Integer.parseInt(testCase[i][0]) - 1;
            String word = testCase[i][1];

            sb.append(word.substring(0, typo)).append(word.substring(typo + 1)).append("\n");
        }
        bw.write(sb.toString());

//        for (int i = 0; i < T; i++) {
//            int typo = Integer.parseInt(testCase[i][0]);
//            String word = testCase[i][1];
//
//            StringBuilder sb = new StringBuilder();
//            for (int j = 0; j < word.length(); j++) {
//                if (typo == j + 1) continue;
//                sb.append(word.charAt(j));
//            }
//            bw.write(sb.toString() + "\n");
//            sb.setLength(0);
//        }

        br.close();
        bw.close();
    }
}
