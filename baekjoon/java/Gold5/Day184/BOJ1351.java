package Gold5.Day184;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1351 {
    private static int P, Q;
    private static Long N;
    private static Map<Long, Long> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        map = new HashMap<>();

        long result = dp(N);

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static long dp(long num) {
        if (num == 0)
            return 1;

        if (map.containsKey(num))
            return map.get(num);

        long a = (long) Math.floor(num / P);
        long b = (long) Math.floor(num / Q);

        map.put(num, dp(a) + dp(b));

        return map.get(num);
    }
}
