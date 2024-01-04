package Day58;

import java.io.*;

public class BOJ1356 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();

        boolean isYuJinSu = false;
        for (int i = 0; i < N.length(); i++) {
            String firstStr = N.substring(0, i + 1);
            String secondStr = N.substring(i + 1);

            if (N.length() == 1)
                break;

            long first = 1;
            long second = 1;
            for (char ch : firstStr.toCharArray())
                first *= ch - '0';
            for (char ch : secondStr.toCharArray())
                second *= ch - '0';

            if (first == second) {
                isYuJinSu = true;
                break;
            }
        }

        if (isYuJinSu)
            bw.write("YES");
        else
            bw.write("NO");

        br.close();
        bw.flush();
        bw.close();
    }
}
