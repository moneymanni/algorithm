package Silver4.Day92;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> pokedexNames = new HashMap<>();
        Map<Integer, String> pokedexNums = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            pokedexNames.put(name, i);
            pokedexNums.put(i, name);
        }

        while (M-- > 0) {
            String input = br.readLine();

            String output;
            if (isNumeric(input)) {
                int inputNum = Integer.parseInt(input);
                output = pokedexNums.get(inputNum);
            } else {
                output = String.valueOf(pokedexNames.get(input));
            }

            bw.write(output + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean isNumeric (String str) {
        return str.matches("[0-9]+");
    }
}
