package Silver3.Day113;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            Map<String, Integer> clothesMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
            }

            int total = 1;
            for (int cnt : clothesMap.values())
                total *= (cnt + 1);
            total -= 1;

            bw.write(total + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
