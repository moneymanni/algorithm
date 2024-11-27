package Day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

//        for (int i = 0; i < T; i++) {
//            st = new StringTokenizer(br.readLine());
//
//            String data = st.nextToken();
//
//            char[] charArray = data.toCharArray();
//
//            System.out.printf("%c%c\n", charArray[0], charArray[charArray.length-1]);
//        }
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            String data = st.nextToken();

            System.out.printf("%c%c\n", data.charAt(0), data.charAt(data.length()-1));
        }
    }
}
