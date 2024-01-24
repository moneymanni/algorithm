package Day37;

import java.io.*;

public class BOJ1159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] lastnameOfPlayers = new String[N];
        for (int i = 0; i < N; i++)
            lastnameOfPlayers[i] = br.readLine();

        int[] alphabets = new int[26];
        for (String player : lastnameOfPlayers)
            alphabets[player.charAt(0) - 'a']++;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] >= 5)
                sb.append(Character.toChars('a' + i));
        }

        if (sb.length() == 0)
            bw.write("PREDAJA");
        else
            bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
