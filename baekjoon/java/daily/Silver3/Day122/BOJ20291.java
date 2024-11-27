package Silver3.Day122;

import java.io.*;
import java.util.*;

public class BOJ20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        String[] extensions = new String[N];
        Map<String, Integer> cntMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), ".");

            String fileName = st.nextToken();
            extensions[i] = st.nextToken();

            cntMap.put(extensions[i], cntMap.getOrDefault(extensions[i], 0) + 1);
        }

        Arrays.sort(extensions);

        Set<String> checkSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String extension = extensions[i];

            if (!checkSet.contains(extension)) {
                checkSet.add(extension);
                sb.append(extension).append(' ').append(cntMap.get(extension)).append('\n');
            }
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }
}
