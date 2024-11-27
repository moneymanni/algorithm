package Silver3.Day125;

import java.io.*;
import java.util.*;

public class BOJ2621 {
    private static final int NUM_OF_CARDS_DRAWN = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < NUM_OF_CARDS_DRAWN; i++) {
            st = new StringTokenizer(br.readLine());
            cards.add(new Card(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        int score = calculateScore(cards);

        bw.write(score + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int calculateScore(List<Card> cards) {
        Map<String, Integer> colorMap = new HashMap<>();
        Map<Integer, Integer> numMap = new TreeMap<>();

        for (Card card : cards) {
            colorMap.put(card.color, colorMap.getOrDefault(card.color, 0) + 1);
            numMap.put(card.number, numMap.getOrDefault(card.number, 0) + 1);
        }

        boolean isAllSameColor = colorMap.size() == 1;
        int[] sortedNums = cards.stream().mapToInt(card -> card.number).sorted().toArray();
        boolean isStraight = isStraight(sortedNums);
        int maxNum = sortedNums[NUM_OF_CARDS_DRAWN - 1];

        int score = 0;
        if (isAllSameColor && isStraight) {
            // 1. 스트레이트 플러쉬
            score = 900 + maxNum;
        } else if (numMap.containsValue(4)) {
            // 2. 포카드
            score = 800 + getKeyOfMaxValue(numMap, 4);
        } else if (numMap.containsValue(3) && numMap.containsValue(2)) {
            // 3. 풀하우스
            score = 700 + getKeyOfMaxValue(numMap, 3) * 10 + getKeyOfMaxValue(numMap, 2);
        } else if (isAllSameColor) {
            // 4. 플러쉬
            score = 600 + maxNum;
        } else if (isStraight) {
            // 5. 스트레이트
            score = 500 + maxNum;
        } else if (numMap.containsValue(3)) {
            // 6. 트리플
            score = 400 + getKeyOfMaxValue(numMap, 3);
        } else if (Collections.frequency(numMap.values(), 2) == 2) {
            int lowPair = getKeyOfMaxValue(numMap, 2);
            numMap.remove(lowPair);
            int highPair = getKeyOfMaxValue(numMap, 2);
            return 300 + highPair * 10 + lowPair;
        } else if (numMap.containsValue(2)) {
            // 8. 원페어
            score = 200 + getKeyOfMaxValue(numMap, 2);
        } else {
            score = 100 + maxNum;
        }

        return score;
    }

    private static boolean isStraight(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                return false;
            }
        }
        return true;
    }

    private static int getKeyOfMaxValue(Map<Integer, Integer> map, int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(value))
                return entry.getKey();
        }
        return -1;
    }

    static class Card {
        String color;
        int number;

        Card(String color, int number) {
            this.color = color;
            this.number = number;
        }
    }
}
