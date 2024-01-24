package Day2;

import java.util.Scanner;

public class BOJ2744 {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//        String word = scan.nextLine().strip();
//        char[] charArr = word.toCharArray();
//
//        for (int i = 0; i < charArr.length; i++) {
//            if ((int) charArr[i] >= 65 && (int) charArr[i] <= 90)
//                charArr[i] = (char) ((int) charArr[i] + 32);
//            else
//                charArr[i] = (char) ((int) charArr[i] - 32);
//        }
//
//        System.out.println(String.valueOf(charArr));
//    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String word = scan.nextLine().strip();
        char[] charArr = word.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            if (Character.isUpperCase(charArr[i]))
                charArr[i] = Character.toLowerCase(charArr[i]);
            else
                charArr[i] = Character.toUpperCase(charArr[i]);
        }

        System.out.println(String.valueOf(charArr));
    }
}