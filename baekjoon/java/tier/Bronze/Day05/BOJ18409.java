package Day5;

import java.util.Scanner;
import java.util.Set;

public class BOJ18409 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        String M = scan.next();

//        Set<Character> vowel = Set.of('a', 'e', 'i', 'o', 'u');
//
//        long count = M.toLowerCase().chars()
//                .filter(ch -> vowel.contains((char) ch))
//                .count();
//        System.out.println(count);

        int cnt = 0;
        for (char ch : M.toCharArray()) {
            switch (ch) {
                case 'a': case 'e': case 'i': case 'o': case 'u':
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}
