package Day26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10102 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());
        char[] vote = br.readLine().toCharArray();

        int cntA = 0;
        int cntB = 0;
        for (int i = 0 ; i < V; i++) {
            if (vote[i] == 'A')
                cntA++;
            else
                cntB++;
        }
        if (cntA > cntB)
            System.out.println("A");
        else if (cntA < cntB)
            System.out.println("B");
        else
            System.out.println("Tie");

        br.close();
    }
}
