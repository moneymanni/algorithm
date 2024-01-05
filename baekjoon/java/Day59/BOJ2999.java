package Day59;

import java.io.*;

public class BOJ2999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String message = br.readLine();

        String decryptedMessage = decryptMessage(message);
        bw.write(decryptedMessage);

        br.close();
        bw.flush();
        bw.close();
    }

    public static String decryptMessage (String message) {
        int R = findR(message.length());
        int C = message.length() / R;

        // 행이 R개, 열이 C개인 행렬
        char[][] matrix = new char[R][C];
        int idx = 0;
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                matrix[j][i] = message.charAt(idx++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char[] row : matrix) {
            for (char ch : row) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static int findR (int messageLen) {
        // R <= C && R * C = N
        int maxR = Integer.MIN_VALUE;
        for (int i = 1; i <= messageLen; i++) {
            for (int j = 1; j <= messageLen; j++) {
                if (i <= j && i * j == messageLen)
                    maxR = Math.max(maxR, i);
            }
        }

        return maxR;
    }
}
