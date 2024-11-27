package Day25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ10987 {
    public static final List<String> vowels = new ArrayList<>(Arrays.asList(new String[]{"a", "e", "i", "o", "u"}));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine().toLowerCase();

        int cnt = 0;
        for (int i = 0; i < line.length(); i++) {
            if (vowels.contains(String.valueOf(line.charAt(i))))
                cnt++;
        }
        System.out.println(cnt);

        br.close();
    }
}
