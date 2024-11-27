package Day60;

import java.io.*;

public class BOJ16968 {
    public static final int NUM_OF_NUMS = 10;
    public static final int NUM_OF_CHARACTERS = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String licensePlate = br.readLine();

        char prevChar = ' ';
        int result = 1;
        for (int i = 0; i < licensePlate.length(); i++) {
            switch (licensePlate.charAt(i)) {
                case 'd':
                    result = prevChar == 'd'
                            ? result * (NUM_OF_NUMS - 1)
                            : result * (NUM_OF_NUMS);
                    prevChar = 'd';
                    break;
                case 'c':
                    result = prevChar == 'c'
                            ? result * (NUM_OF_CHARACTERS - 1)
                            : result * (NUM_OF_CHARACTERS);
                    prevChar = 'c';
                    break;
            }
        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
