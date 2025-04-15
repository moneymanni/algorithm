package StepByStep.setandmap;

import java.io.*;
import java.util.*;

public class BOJ1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        while (N-- > 0) {
            String name = br.readLine();

            set.add(name);
        }

        while (M-- > 0) {
            String name = br.readLine();

            if (set.contains(name)) {
                list.add(name);
            }
        }

        Collections.sort(list);

        bw.write(list.size() + "\n");
        for (String name : list) {
            bw.write(name + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
