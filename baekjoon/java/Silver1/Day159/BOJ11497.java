package Silver1.Day159;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            Log[] logs = new Log[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                logs[i] = new Log(Integer.parseInt(st.nextToken()));

            Arrays.sort(logs);

            int result = -1;
            Log prevLog = logs[0];

            for (int i = 2; i < N; i += 2) {
                result = Math.max(result, Math.abs(prevLog.height - logs[i].height));
                prevLog = logs[i];
            }

            if (N % 2 == 0) N++;

            for (int i = N - 2; i > 0; i -= 2) {
                result = Math.max(result, Math.abs(prevLog.height - logs[i].height));
                prevLog = logs[i];
            }

            result = Math.max(result, Math.abs(prevLog.height - logs[0].height));

            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static class Log implements Comparable<Log> {
        int height;

        public Log (int height) {
            this.height = height;
        }

        @Override
        public int compareTo(Log obj) {
            return this.height - obj.height;
        }
    }
}
