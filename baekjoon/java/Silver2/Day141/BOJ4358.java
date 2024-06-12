package Silver2.Day141;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class BOJ4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int total = 0;
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        String line;

//        while (!(line = br.readLine()).equals("EOF")) {  // EOF
        while ((line = br.readLine()) != null) {
            treeMap.put(line, treeMap.getOrDefault(line, 0) + 1);
            total++;
        }

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String treeName = entry.getKey();
            int treeNum = entry.getValue();

            sb.append(treeName)
                    .append(' ')
                    .append(String.format("%.4f", treeNum * 100.0 / total))
                    .append('\n');
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }
}
