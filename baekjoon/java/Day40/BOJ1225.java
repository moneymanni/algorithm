package Day40;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();

        long sum = 0;
        for (int i = 0; i < charsA.length; i++) {
            for (int j = 0; j < charsB.length; j++)
                sum += (charsA[i] - '0') * (charsB[j] - '0');
        }
        bw.write(sum + "");

        br.close();
        bw.close();
    }
}
