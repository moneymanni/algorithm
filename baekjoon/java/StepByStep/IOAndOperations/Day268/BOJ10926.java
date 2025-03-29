package StepByStep.IOAndOperations.Day268;

import java.util.Scanner;

public class BOJ10926 {

    private static final String SURPRISE = "??!";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        String result = add(str, SURPRISE);

        System.out.println(result);
    }

    private static String add(String str1, String str2) {
        return str1 + str2;
    }
}
