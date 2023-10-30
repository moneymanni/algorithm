package Day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ6810 {
    static final String ISBN_10 = "9780921418";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Character> isbn = new ArrayList<>();
        for (Character c : ISBN_10.toCharArray())
            isbn.add(c);
        for (int i = 0; i < 3; i++)
            isbn.add(br.readLine().charAt(0));

        int result = 0;
        for (int i = 0; i < 13; i++) {
            if (i % 2 == 0)
                result += (isbn.get(i) - '0') * 1;
            else
                result += (isbn.get(i) - '0') * 3;
        }
        System.out.printf("The 1-3-sum is %d\n", result);
        br.close();
    }
}
