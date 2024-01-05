package Day59;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int lenA = A.length();
        int lenB = B.length();

        int idxA = -1, idxB = -1;
        boolean isFound = false;
        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    idxA = i;
                    idxB = j;
                    isFound = true;
                    break;
                }
            }
            if (isFound) break;
        }

        StringBuilder sb = new StringBuilder();
        int cntA = 0, cntB = 0;
        for (int i = 0; i < lenB; i++) {
            for (int j = 0; j < lenA; j++) {
                if (i == idxB && j == idxA) {
                    sb.append(A.charAt(cntA++));
                    cntB++;
                } else if (i == idxB) {
                    sb.append(A.charAt(cntA++));
                } else if (j == idxA) {
                    sb.append(B.charAt(cntB++));
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
