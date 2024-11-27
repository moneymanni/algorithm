package Day27;

import java.io.*;

public class BOJ1284 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;

            char[] carPlate = String.valueOf(N).toCharArray();
            int cnt = 1;
            for (char num : carPlate) {
                if (num == '0')
                    cnt += 4;
                else if (num == '1')
                    cnt += 2;
                else
                    cnt += 3;
                cnt += 1;
            }
            bw.write(cnt + "\n");
        }

        br.close();
        bw.close();
    }
}
