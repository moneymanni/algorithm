package StepByStep.setandmap;

import java.io.*;
import java.util.*;

public class BOJ7785 {

    private static final String ENTER = "enter";
    private static final String LEAVE = "leave";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String commuting = st.nextToken();

            if (commuting.equals(ENTER)) {
                set.add(name);
            } else if (commuting.equals(LEAVE)) {
                set.remove(name);
            }
        }

        List<String> list = new ArrayList<>(set);

        list.sort(Collections.reverseOrder());

        for (String name : list) {
            bw.write(name + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
