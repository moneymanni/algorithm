package Day9;

import java.io.*;

public class BOJ1264 {
    public static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int sum = 0;
            String line = br.readLine().strip();
            if (line.charAt(0) == '#')
                break;
            for (int i = 0; i < line.length(); i++)
                for (char vowel : VOWELS)
                    if (vowel == line.toLowerCase().charAt(i))
                        ++sum;
            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
    }
}
