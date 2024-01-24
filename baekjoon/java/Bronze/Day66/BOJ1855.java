package Day66;

import java.io.*;

public class BOJ1855 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        String encryptedStr = br.readLine();

        int strLen = encryptedStr.length();
        int row = strLen % K == 0 ? strLen / K : strLen / K + 1;
        char[][] table = new char[row][K];
        int cnt = 0;
        boolean satisfyCondition = false;
        for (int i = 0; i < row; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < K; j++) {
                    if (cnt > strLen - 1) {
                        satisfyCondition = true;
                        break;
                    }
                    table[i][j] = encryptedStr.charAt(cnt++);
                }
            } else {
                for (int j = K - 1; j >= 0; j--) {
                    if (cnt > strLen - 1) {
                        satisfyCondition = true;
                        break;
                    }
                    table[i][j] = encryptedStr.charAt(cnt++);
                }
            }
            if (satisfyCondition) break;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < row; j++) {
                if (table[j][i] != ' ')
                    sb.append(table[j][i]);
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
