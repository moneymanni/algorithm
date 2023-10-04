package Day9;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class BOJ11948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer[] naturalScience = new Integer[4];
        for (int i = 0; i < naturalScience.length; i++)
            naturalScience[i] = Integer.parseInt(br.readLine().strip());

        Integer[] liberalArts = new Integer[2];
        for (int i = 0; i < liberalArts.length; i++)
            liberalArts[i] = Integer.parseInt(br.readLine().strip());

        Arrays.sort(naturalScience, Collections.reverseOrder());
        Arrays.sort(liberalArts, Collections.reverseOrder());

        int result = naturalScience[0] + naturalScience[1] + naturalScience[2] + liberalArts[0];

        bw.write(result + "");

        bw.flush();
        bw.close();
    }
}
