package StepByStep.Advanced1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2941 {

    private static final String[] CROATIAN_ALPHABETS =
            {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int cnt = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (i + 1 < input.length()) {
                switch (ch) {
                    case 'c':
                        if (input.charAt(i + 1) == '=' || input.charAt(i + 1) == '-') {
                            cnt++;
                            i++;
                            continue;
                        }
                        break;
                    case 'd':
                        if (i + 2 < input.length()
                                && input.charAt(i + 1) == 'z'
                                && input.charAt(i + 2) == '=') {
                            cnt++;
                            i += 2;
                            continue;
                        } else if (input.charAt(i + 1) == '-') {
                            cnt++;
                            i++;
                            continue;
                        }
                        break;
                    case 'l': case 'n':
                        if (input.charAt(i + 1) == 'j') {
                            cnt++;
                            i++;
                            continue;
                        }
                        break;
                    case 's': case 'z':
                        if (input.charAt(i + 1) == '=') {
                            cnt++;
                            i++;
                            continue;
                        }
                        break;
                }
            }
            cnt++;
        }

        System.out.println(cnt);

        br.close();
    }
}
