package Silver3.Day122;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class BOJ13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        LinkedHashMap<String, String> listMap = new LinkedHashMap<>();
        for (int i = 0; i < L; i++) {
            String studentId = br.readLine();
            listMap.remove(studentId);
            listMap.put(studentId, null);
        }

        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for (String studentId : listMap.keySet()) {
            if (cnt++ == K)
                break;
            sb.append(studentId).append('\n');
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
