package Day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] telephoneNum = br.readLine().toCharArray();
        String prefixNum = "";
        for (int i = 0; i < 3; i++)
            prefixNum += Character.toString(telephoneNum[i]);

        if (prefixNum.equals("555"))
            System.out.println("YES");
        else
            System.out.println("NO");

        br.close();
    }
}
