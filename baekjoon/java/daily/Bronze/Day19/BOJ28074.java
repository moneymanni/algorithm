package Day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ28074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine().toUpperCase();
        if (line.contains("M") && line.contains("O") && line.contains("B") && line.contains("I") && line.contains("S"))
            System.out.println("YES");
        else
            System.out.println("NO");

        br.close();
    }
}
