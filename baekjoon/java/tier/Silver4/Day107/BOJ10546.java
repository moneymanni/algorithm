package Silver4.Day107;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BOJ10546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> list = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            list.put(name, list.getOrDefault(name, 0) + 1);
        }

        for (int i = 0; i < N - 1; i++) {
            String name = br.readLine();
            list.put(name, list.getOrDefault(name, 0) - 1);
        }

        for (Map.Entry<String, Integer> entry : list.entrySet()) {
            String name = entry.getKey();
            int value = entry.getValue();

            if (value != 0)
                bw.write(name);
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
