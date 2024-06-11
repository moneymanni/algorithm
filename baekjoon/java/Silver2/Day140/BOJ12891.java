package Silver2.Day140;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ12891 {
    private static final char[] DNAArr = new char[]{'A', 'C', 'G', 'T'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String DNAStr = br.readLine();

        Map<Character, Integer> DNAPwdConditionMap = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (char DNA : DNAArr) {
            int num = Integer.parseInt(st.nextToken());
            DNAPwdConditionMap.put(DNA, num);
        }

        Map<Character, Integer> DNAMap = new HashMap<>();

        for (char DNA : DNAArr)
            DNAMap.put(DNA, 0);

        for (int i = 0; i < P; i++)
            DNAMap.put(DNAStr.charAt(i), DNAMap.get(DNAStr.charAt(i)) + 1);

        int cnt = 0;

        for (int i = 0; i <= S - P; i++) {
            boolean flag = true;

            if (i != 0) {
                DNAMap.put(DNAStr.charAt(i + P - 1), DNAMap.get(DNAStr.charAt(i + P - 1)) + 1);
                DNAMap.put(DNAStr.charAt(i - 1), DNAMap.get(DNAStr.charAt(i - 1)) - 1);
            }

            for (char DNA : DNAArr) {
                if (DNAMap.get(DNA) < DNAPwdConditionMap.get(DNA)) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                cnt++;
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
