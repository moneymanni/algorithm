package Silver4.Day91;

import java.io.*;
import java.util.*;

public class BOJ1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 듣도 못한 사람의 수
        int M = Integer.parseInt(st.nextToken());  // 보도 못한 사람의 수

        Set<String> names = new HashSet<>();
        List<String> list = new ArrayList<>();

        while (N-- > 0)
            names.add(br.readLine());

        while (M-- > 0) {
            String name = br.readLine();
            if (names.contains(name))
                list.add(name);
        }

        Collections.sort(list);

        bw.write(list.size() + "\n");
        for (String name : list)
            bw.write(name + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
