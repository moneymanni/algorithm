package Silver5.Day74;

import java.io.*;
import java.util.*;

public class BOJ7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Map<String, String> logs = new HashMap<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String state = st.nextToken();

            if (logs.containsKey(name))
                logs.remove(name);
            else
                logs.put(name, state);
        }

        List<String> list = new ArrayList<>(logs.keySet());
        Collections.sort(list, Collections.reverseOrder());
        for (String str : list)
            bw.write(str + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
