package Silver3.Day121;

import java.io.*;
import java.util.*;

public class BOJ2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Integer[] messages = new Integer[N];
        Map<Integer, Integer> frequency = new HashMap<>();
        Map<Integer, Integer> order = new HashMap<>();
        for (int i = 0; i < N; i++) {
            messages[i] = Integer.parseInt(st.nextToken());
            frequency.put(messages[i], frequency.getOrDefault(messages[i], 0) + 1);
            order.putIfAbsent(messages[i], i);
        }

        Arrays.sort(messages, (a, b) -> {
            int freq = frequency.get(b).compareTo(frequency.get(a));
            if (freq == 0)
                return order.get(a) - order.get(b);
            return freq;
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            sb.append(messages[i]).append(' ');

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
