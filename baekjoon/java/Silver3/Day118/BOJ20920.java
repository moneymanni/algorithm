package Silver3.Day118;

import java.io.*;
import java.util.*;

public class BOJ20920 {
    private static int N, M;
    private static String[] words, temp;
    private static Map<String, Integer> wordMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        words = new String[N + 1];
        temp = new String[N + 1];
        wordMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            words[i] = br.readLine();
            wordMap.put(words[i], wordMap.getOrDefault(words[i], 0) + 1);
        }

        mergeSort(1, N);

        Set<String> checkSet = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            if (!checkSet.contains(words[i]) && words[i].length() >= M) {
                bw.write(words[i] + "\n");
                checkSet.add(words[i]);
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void mergeSort (int start, int end) {
        if (end - start < 1)
            return;

        int mid = start + (end - start) / 2;

        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        for (int i = start; i <= end; i++)
            temp[i] = words[i];

        int k = start;
        int idx1 = start, idx2 = mid + 1;
        while (idx1 <= mid && idx2 <= end) {
            if (compare(temp[idx1], temp[idx2]) < 0)
                words[k++] = temp[idx1++];
            else
                words[k++] = temp[idx2++];
        }

        while (idx1 <= mid)
            words[k++] = temp[idx1++];
        while (idx2 <= end)
            words[k++] = temp[idx2++];
    }

    private static int compare (String word1, String word2) {
        int freqCompare = Integer.compare(wordMap.get(word2), wordMap.get(word1));
        if (freqCompare != 0) return freqCompare;

        int lengthCompare = Integer.compare(word2.length(), word1.length());
        if (lengthCompare != 0) return lengthCompare;

        return word1.compareTo(word2);
    }
}
