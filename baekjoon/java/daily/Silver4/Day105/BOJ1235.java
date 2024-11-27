package Silver4.Day105;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class BOJ1235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] ids = new String[N];
        for (int i = 0; i < N; i++)
            ids[i] = br.readLine();

        int minLen = findMinK(ids, N);
        bw.write(minLen + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int findMinK(String[] ids, int N) {
        int len = ids[0].length();

        for (int k = 0; k <= len; k++) {
            Set<String> unique = new HashSet<>();

            boolean isAllDiff = true;
            for (String num : ids) {
                String sub = num.substring(len - k);

                if (!unique.add(sub)) {
                    isAllDiff = false;
                    break;
                }
            }

            if (isAllDiff)
                return k;
        }

        return len;
    }
}
