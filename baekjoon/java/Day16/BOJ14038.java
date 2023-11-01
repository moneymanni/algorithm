package Day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14038 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int win = 0;
        for (int i = 0; i < 6; i++) {
            String input = br.readLine();
            if (input.equals("W"))
                win++;
        }

        int group = -1;
        switch (win) {
            case 6:
            case 5:
                group = 1;
                break;
            case 4:
            case 3:
                group = 2;
                break;
            case 2:
            case 1:
                group = 3;
                break;
        }
        System.out.println(group);

        br.close();
    }
}
