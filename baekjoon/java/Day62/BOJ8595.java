package Day62;

import java.io.*;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BOJ8595 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String alphabet = br.readLine();

        // 풀이 1
//        char[] charsStr = alphabet.toCharArray();
//
//        StringBuilder sb = new StringBuilder();
//        long sum = 0;
//        for (int i = 0; i < n; i++) {
//            if ('0' <= charsStr[i] && charsStr[i] <= '9') {
//                sb.append(charsStr[i]);
//            } else if (sb.length() > 0){
//                sum += Long.parseLong(sb.toString());
//                sb.setLength(0);
//            }
//        }
//
//        if (sb.length() > 0)
//            sum += Long.parseLong(sb.toString());
//
//        bw.write(sum + "");

        // 풀이 2
        long sum = 0;
        StringTokenizer st = new StringTokenizer(alphabet.replaceAll("[a-zA-Z]", " "));
        while (st.hasMoreTokens())
            sum += Long.parseLong(st.nextToken());

        bw.write(sum + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
