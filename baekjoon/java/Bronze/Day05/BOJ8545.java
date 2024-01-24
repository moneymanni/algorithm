package Day5;


import java.util.Scanner;

public class BOJ8545 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine().strip();

//        // char[]로 변환 후 반전, 0.0001295001s
//        char[] charArray = word.toCharArray();
//        for (int i = charArray.length - 1; i >= 0; i--)
//            System.out.print(charArray[i]);

        // StringBuffer 사용, 0.0000439001s, 3 배 빠름...
        StringBuffer sb = new StringBuffer(word);
        String reversedWord = sb.reverse().toString();
        System.out.println(reversedWord);
    }
}
