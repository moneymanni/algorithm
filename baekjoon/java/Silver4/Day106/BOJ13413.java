package Silver4.Day106;

import java.io.*;

public class BOJ13413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String init = br.readLine();
            String goal = br.readLine();

            int wToB = 0, bToW = 0;
            for (int k = 0; k < N; k++) {
                if (init.charAt(k) != goal.charAt(k)) {
                    if (init.charAt(k) == 'W')
                        wToB++;
                    else
                        bToW++;
                }
            }

            result.append(Math.min(wToB, bToW) + Math.abs(wToB - bToW)).append('\n');
        }

        bw.write(result.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
