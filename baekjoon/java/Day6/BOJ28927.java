package Day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ28927 {
    public static final int PREVIEW = 3;
    public static final int TV_SERIES = 20;
    public static final int MOVIE = 120;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t1 = Integer.parseInt(st.nextToken());
        int e1 = Integer.parseInt(st.nextToken());
        int f1 = Integer.parseInt(st.nextToken());
        int max = t1*PREVIEW + e1*TV_SERIES + f1*MOVIE;

        st = new StringTokenizer(br.readLine());
        int t2 = Integer.parseInt(st.nextToken());
        int e2 = Integer.parseInt(st.nextToken());
        int f2 = Integer.parseInt(st.nextToken());
        int mel = t2*PREVIEW + e2*TV_SERIES + f2*MOVIE;

        if (max == mel) System.out.println("Draw");
        else if (max > mel) System.out.println("Max");
        else System.out.println("Mel");
    }
}
