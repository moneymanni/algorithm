package Day32;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] notes = new int[8];
        for (int i = 0; i < notes.length; i++)
            notes[i] = Integer.parseInt(st.nextToken());

        boolean isAscending = true;
        boolean isDescending = true;
        for (int i = 1; i < notes.length; i++) {
            if (notes[i-1] > notes[i])
                isAscending = false;
            else if (notes[i-1] < notes[i])
                isDescending = false;
        }
        if (isAscending)
            bw.write("ascending");
        else if (isDescending)
            bw.write("descending");
        else
            bw.write("mixed");

        br.close();
        bw.close();
    }
}
