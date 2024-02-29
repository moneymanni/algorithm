package Silver5.Day80;

import java.io.*;

public class BOJ1769 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String X = br.readLine();

        int cnt = 0;
        while (X.length() != 1) {
            int sum = 0;
            for (int i = 0; i < X.length(); i++) {
                int num = X.charAt(i) - '0';
                sum += num;
            }
            X = String.valueOf(sum);
            cnt++;
        }
        bw.write(cnt + "\n");
        if (Integer.parseInt(X) % 3 == 0)
            bw.write("YES");
        else
            bw.write("NO");

        br.close();
        bw.flush();
        bw.close();
    }
}
