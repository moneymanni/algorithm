package Silver1.Day164;

import java.io.*;
import java.util.*;

public class BOJ1141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] strs = new String[N];

        for (int i = 0; i < N; i++)
            strs[i] = br.readLine();

        Arrays.sort(strs, (a, b) -> b.length() - a.length());

        List<String> nonPrefix = new ArrayList<>();

        for (String currStr : strs) {
            if (nonPrefix.isEmpty()) {
                nonPrefix.add(currStr);
                continue;
            }

            boolean isPrefix = false;

            for (String existingStr : nonPrefix) {
                if (existingStr.indexOf(currStr) == 0) {
                    isPrefix = true;
                    break;
                }
            }

            if (!isPrefix)
                nonPrefix.add(currStr);
        }

        bw.write(String.valueOf(nonPrefix.size()));

        br.close();
        bw.flush();
        bw.close();
    }
}
