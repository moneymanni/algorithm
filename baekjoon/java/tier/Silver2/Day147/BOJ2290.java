package Silver2.Day147;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2290 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        String n = st.nextToken();

        SevenSegmentDisplay ssd = new SevenSegmentDisplay(n, s);

        bw.write(ssd.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static class SevenSegmentDisplay {
        String strNumber;
        long number;
        int size;
        int width;
        int height;
        char[][] result;
        char hyphen = '-';
        char verticalBar = '|';

        public SevenSegmentDisplay(String strNumber, int size) {
            this.strNumber = strNumber;
            this.size = size;

            number = Integer.parseInt(strNumber);

            width = (size + 2) * strNumber.length();
            height = 2 * size + 3;

            result = new char[height][width + 1];
            for (int i = 0; i < height; i++)
                Arrays.fill(result[i], ' ');

            for (int i = 0; i < strNumber.length(); i++) {
                int num = Character.getNumericValue(strNumber.charAt(i));
                printNumber(num, i);
            }
        }

        private void printNumber(int num, int idx) {
            switch (num) {
                case 1:
                    printVerticalBar(idx, 3);
                    printVerticalBar(idx, 4);
                    break;
                case 2:
                    printHyphen(idx, 0);
                    printVerticalBar(idx, 3);
                    printHyphen(idx, 1);
                    printVerticalBar(idx, 2);
                    printHyphen(idx, 2);
                    break;
                case 3:
                    printHyphen(idx, 0);
                    printVerticalBar(idx, 3);
                    printHyphen(idx, 1);
                    printVerticalBar(idx, 4);
                    printHyphen(idx, 2);
                    break;
                case 4:
                    printVerticalBar(idx, 1);
                    printVerticalBar(idx, 3);
                    printHyphen(idx, 1);
                    printVerticalBar(idx, 4);
                    break;
                case 5:
                    printHyphen(idx, 0);
                    printVerticalBar(idx, 1);
                    printHyphen(idx, 1);
                    printVerticalBar(idx, 4);
                    printHyphen(idx, 2);
                    break;
                case 6:
                    printHyphen(idx, 0);
                    printVerticalBar(idx, 1);
                    printHyphen(idx, 1);
                    printVerticalBar(idx, 2);
                    printVerticalBar(idx, 4);
                    printHyphen(idx, 2);
                    break;
                case 7:
                    printHyphen(idx, 0);
                    printVerticalBar(idx, 3);
                    printVerticalBar(idx, 4);
                    break;
                case 8:
                    printHyphen(idx, 0);
                    printVerticalBar(idx, 1);
                    printVerticalBar(idx, 3);
                    printHyphen(idx, 1);
                    printVerticalBar(idx, 2);
                    printVerticalBar(idx, 4);
                    printHyphen(idx, 2);
                    break;
                case 9:
                    printHyphen(idx, 0);
                    printVerticalBar(idx, 1);
                    printVerticalBar(idx, 3);
                    printHyphen(idx, 1);
                    printVerticalBar(idx, 4);
                    printHyphen(idx, 2);
                    break;
                case 0:
                    printHyphen(idx, 0);
                    printVerticalBar(idx, 1);
                    printVerticalBar(idx, 3);
                    printVerticalBar(idx, 2);
                    printVerticalBar(idx, 4);
                    printHyphen(idx, 2);
                    break;
            }
        }

        private void printHyphen(int idx, int cmd) {
            int row = cmd * size + cmd;
            int col = idx * (size + 2) + 2;

            for (int i = 0; i < size; i++)
                result[row][col + i] = hyphen;
        }

        private void printVerticalBar(int idx, int cmd) {
            if (cmd == 1 || cmd == 2) {
                int col = idx * (size + 2) + 1;
                int row = (cmd - 1) * size + cmd;

                for (int i = 0; i < size; i++)
                    result[row + i][col] = verticalBar;
            } else if (cmd == 3 || cmd == 4) {
                int col = idx * (size + 2) + size + 2;
                int row = (cmd - 3) * size + (cmd - 2);

                for (int i = 0; i < size; i++)
                    result[row + i][col] = verticalBar;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < height; i++) {
                for (int j = 1; j <= width; j++) {
                    sb.append(result[i][j]);

                    if (j % (size + 2) == 0)
                        sb.append(' ');
                }
                sb.append('\n');
            }

            return sb.toString();
        }
    }
}
