package Silver3.Day123;

import java.io.*;
import java.util.*;

public class BOJ16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, List<String>> teamMap = new HashMap<>();
        Map<String, String> memberMap = new HashMap<>();
        while (N-- > 0) {
            String teamName = br.readLine();
            int memberNum = Integer.parseInt(br.readLine());

            teamMap.put(teamName, new ArrayList<>());
            while (memberNum-- > 0) {
                String memberName = br.readLine();

                teamMap.get(teamName).add(memberName);
                memberMap.put(memberName, teamName);
            }
            Collections.sort(teamMap.get(teamName));
        }

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            String name = br.readLine();
            int option = Integer.parseInt(br.readLine());

            if (option == 0) {
                for (String memberName : teamMap.get(name))
                    sb.append(memberName).append('\n');
            } else if (option == 1) {
                sb.append(memberMap.get(name)).append('\n');
            }
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }
}
