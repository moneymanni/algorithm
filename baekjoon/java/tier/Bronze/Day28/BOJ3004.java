package Day28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int pieceNum = 1;
        int temp = 1;
        for (int i = 0; i < N; i++) {
            if (i%2 != 0)
                temp++;
            pieceNum += temp;
        }
        System.out.println(pieceNum);

        br.close();
    }
}
