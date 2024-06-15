package Silver2.Day142;

import java.io.*;

public class BOJ2089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String answer = decimalToMinusBinary(N);
        bw.write(answer);

        br.close();
        bw.flush();
        bw.close();
    }

    private static String decimalToMinusBinary(int num) {
        StringBuilder sb = new StringBuilder();

        if (num == 0) {
            sb.append(0);
        } else {
            while (num != 1) {
                sb.append(Math.abs(num % 2));

                num = (int)(Math.ceil((double) num / -2));
            }

            sb.append(num);
        }

        return sb.reverse().toString();
    }
}
