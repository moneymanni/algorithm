package Day26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] kangaroo = new int[3];
        for (int i = 0; i < kangaroo.length; i++)
            kangaroo[i] = Integer.parseInt(st.nextToken());

        int emptyA = kangaroo[1] - kangaroo[0] - 1;
        int emptyB = kangaroo[2] - kangaroo[1] - 1;
        System.out.println(Math.max(emptyA, emptyB));

        br.close();
    }
}
