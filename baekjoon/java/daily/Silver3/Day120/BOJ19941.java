package Silver3.Day120;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ19941 {
    static char[] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        table = br.readLine().toCharArray();

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (table[i] == 'P') {
                int idx = Math.max(i - K, 0);
                boolean check = false;
                for (int j = idx; j < i; j++) {
                    if (berger(j)) {
                        check = true;
                        cnt++;
                        break;
                    }
                }

                if (!check) {
                    idx = i + K >= N ? N - 1 : i + K;
                    for (int j = i + 1; j <= idx; j++) {
                        if (berger(j)) {
                            cnt++;
                            break;
                        }
                    }
                }
            }
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }

    static boolean berger (int idx) {
        if (table[idx] == 'H') {
            table[idx] = '-';
            return true;
        }
        return false;
    }
}
