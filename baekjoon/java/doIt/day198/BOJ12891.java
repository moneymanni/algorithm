package doit.day198;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class BOJ12891 {

    private static final char[] DNA = {'A', 'C', 'G', 'T'};

    private static int S, P;
    private static int checkSecret;
    private static Map<Character, Integer> conditionMap, arrMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        conditionMap = new HashMap<>();
        arrMap = new HashMap<>();
        checkSecret = 0;

        for (char dna : DNA) {
            arrMap.put(dna, 0);
        }

        String str = br.readLine();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            conditionMap.put(DNA[i], Integer.parseInt(st.nextToken()));

            if (conditionMap.get(DNA[i]) == 0)
                checkSecret++;
        }

        int cnt = countNumDNAPwd(str);

        bw.write(cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int countNumDNAPwd(String str) {
        int cnt = 0;

        for (int i = 0; i < P; i++) {
            add(str.charAt(i));
        }

        if (checkSecret == 4) cnt++;

        for (int i = P; i < S; i++) {
            int j = i - P;

            add(str.charAt(i));
            remove(str.charAt(j));

            if (checkSecret == 4) cnt++;
        }

        return cnt;
    }

    private static void add(char ch) {
        arrMap.put(ch, arrMap.get(ch) + 1);
        if (Objects.equals(arrMap.get(ch), conditionMap.get(ch)))
            checkSecret++;
    }

    private static void remove(char ch) {
        if (Objects.equals(arrMap.get(ch), conditionMap.get(ch)))
            checkSecret--;
        arrMap.put(ch, arrMap.get(ch) - 1);
    }
}
