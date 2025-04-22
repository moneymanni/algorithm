package StepByStep.advanced2;

import java.io.*;
import java.util.*;

public class BOJ20920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> wordMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordMap.entrySet());

        wordList.sort((a, b) -> {
            if (a.getValue() != b.getValue()) {
                return b.getValue() - a.getValue();
            } else {
                if (a.getKey().length() != b.getKey().length()) {
                    return b.getKey().length() - a.getKey().length();
                } else {
                    return a.getKey().compareTo(b.getKey());
                }
            }
        });

        for (Map.Entry<String, Integer> entry : wordList) {
            if (entry.getKey().length() >= M) {
                bw.write(entry.getKey() + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
