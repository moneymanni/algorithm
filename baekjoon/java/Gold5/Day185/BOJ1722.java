package Gold5.Day185;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        boolean[] visited = new boolean[N + 1];

        arr[0] = 1;

        for (int i = 1; i < N; i++)
            arr[i] = arr[i - 1] * i;

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        if (st.nextToken().equals("1")) {
            long num = Long.parseLong(st.nextToken()) - 1;

            for (int i = N; i > 0; i--) {
                long iNum = num / arr[i - 1] + 1;
                long cnt = 0;
                int idx = 0;

                num %= arr[i - 1];

                while (cnt != iNum) {
                    if (!visited[++idx])
                        cnt++;
                }

                visited[idx] = true;

                sb.append(idx).append(' ');
            }
        } else {
            long num = 1;

            for(int i = N; i > 0; i--) {
                int element = Integer.parseInt(st.nextToken());
                int idx = 0;
                int cnt = 0;

                while (idx != element) {
                    if (!visited[++idx])
                        cnt++;
                }

                visited[idx] = true;

                num += (cnt - 1) * arr[i - 1];
            }

            sb.append(num);
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
