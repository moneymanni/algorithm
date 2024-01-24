package Day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = st.nextToken().strip();

        st = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(st.nextToken());

        System.out.println(S.charAt(i-1));
    }
}
