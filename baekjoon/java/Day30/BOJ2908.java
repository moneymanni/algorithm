package Day30;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] charsA = st.nextToken().toCharArray();
        char[] charsB = st.nextToken().toCharArray();

        StringBuilder temp = new StringBuilder();
        for (int i = charsA.length - 1; i >= 0; i--)
            temp.append(charsA[i]);
        int A = Integer.parseInt(temp.toString());

        temp.setLength(0);
        for (int i = charsB.length - 1; i >= 0; i--)
            temp.append(charsB[i]);
        int B = Integer.parseInt(temp.toString());

        int result = Math.max(A, B);
        bw.write(result + "");


        br.close();
        bw.close();
    }
}
