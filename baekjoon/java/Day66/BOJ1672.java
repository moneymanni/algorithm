package Day66;

import java.io.*;

public class BOJ1672 {
    public static final char[][] TABLE =
            {{'A', 'C', 'A', 'G'},
            {'C', 'G', 'T', 'A'},
            {'A', 'T', 'C', 'G'},
            {'G', 'A', 'G', 'T'}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringBuilder nucleicAcidSequence = new StringBuilder(br.readLine());

        for (int i = 0; i < N - 1; i++) {
            int len = nucleicAcidSequence.length();

            int A = convertDNAIntoValue(nucleicAcidSequence.charAt(len - 1));
            int B = convertDNAIntoValue(nucleicAcidSequence.charAt(len - 2));

            char result = TABLE[A][B];

            nucleicAcidSequence.setCharAt(len - 2, result);
            nucleicAcidSequence.deleteCharAt(len - 1);
        }

        bw.write(nucleicAcidSequence.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static int convertDNAIntoValue (char dnaChar) {
        int value = -1;
        switch (dnaChar) {
            case 'A':
                value = 0;
                break;
            case 'G':
                value = 1;
                break;
            case 'C':
                value = 2;
                break;
            case 'T':
                value = 3;
                break;
        }
        return value;
    }
}
