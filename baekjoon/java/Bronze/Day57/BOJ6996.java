package Day57;

//import java.io.*;
//import java.util.StringTokenizer;
//
//public class BOJ6996 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int T = Integer.parseInt(br.readLine());
//        String[][] testCase = new String[T][2];
//        for (int i = 0; i < testCase.length; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < testCase[i].length; j++)
//                testCase[i][j] = st.nextToken();
//        }
//
//        for (int i = 0; i < T; i++) {
//            int[] AAlphabets = new int[26];
//            int[] BAlphabets = new int[26];
//
//            char[] charsA = testCase[i][0].toCharArray();
//            char[] charsB = testCase[i][1].toCharArray();
//            for (char ch : charsA)
//                AAlphabets[ch - 'a']++;
//            for (char ch : charsB)
//                BAlphabets[ch - 'a']++;
//
//            boolean isAnagram = true;
//            for (int j = 0; j < BAlphabets.length; j++) {
//                if (AAlphabets[j] < BAlphabets[j]) {
//                    isAnagram = false;
//                    break;
//                }
//            }
//            if (charsA.length != charsB.length)
//                isAnagram = false;
//
//            bw.write(String.format("%s & %s ", testCase[i][0], testCase[i][1]));
//            if (isAnagram)
//                bw.write("are anagrams.\n");
//            else
//                bw.write("are NOT anagrams.\n");
//        }
//
//        br.close();
//        bw.flush();
//        bw.close();
//    }
//}

import java.util.Scanner;

public class BOJ6996 {
    public static final int ALPHABETS_NUM = 26;

    private static boolean solveAnagrams(String first, String second ) {
        /* ------------------- INSERT CODE HERE --------------------*/

        boolean isAnagram = true;

        if (first.length() != second.length()) {
            isAnagram = false;
        } else {
            int[] firstAlphabets = new int[ALPHABETS_NUM];
            int[] secondAlphabets = new int[ALPHABETS_NUM];

            char[] firstChars = first.toCharArray();
            char[] secondChars = second.toCharArray();
            for (char ch : firstChars)
                firstAlphabets[ch - 'a']++;
            for (char ch : secondChars)
                secondAlphabets[ch - 'a']++;

            for (int j = 0; j < ALPHABETS_NUM; j++) {
                if (firstAlphabets[j] < secondAlphabets[j]) {
                    isAnagram = false;
                    break;
                }
            }
        }

        return isAnagram;

        /* -------------------- END OF INSERTION --------------------*/
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for (int i = 0; i < numTests; i++) {
            String first = sc.next().toLowerCase();
            String second = sc.next().toLowerCase();

            System.out.println(first + " & " + second + " are " + (solveAnagrams(first, second) ? "anagrams." : "NOT anagrams."));
        }
    }
}