package StepByStep.setandmap;

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

        Map<Integer, String> idxToName = new HashMap<>();
        Map<String, Integer> nameToIdx = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String pokemonName = br.readLine();

            idxToName.put(i, pokemonName);
            nameToIdx.put(pokemonName, i);
        }

        while (M-- > 0) {
            String input = br.readLine();

            if (Character.isDigit(input.charAt(0))) {
                int idx = Integer.parseInt(input);

                bw.write(idxToName.get(idx) + "\n");
            } else {
                String name = input;

                bw.write(nameToIdx.get(name) + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
