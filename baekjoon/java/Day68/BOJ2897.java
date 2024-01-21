package Day68;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2897 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] parking = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++)
                parking[i][j] = line.charAt(j);
        }

        int[] results = new int[5];
        for (int i = 0; i < R - 1; i++) {
            for (int j = 0; j < C - 1; j++) {
                char[] parkingSpace = {parking[i][j], parking[i][j + 1], parking[i + 1][j], parking[i + 1][j + 1]};

                int numOfParkedCars = 0;
                int numOfBuildings = 0;
                for (char ch : parkingSpace) {
                    switch (ch) {
                        case '#':
                            numOfBuildings++;
                            break;
                        case 'X':
                            numOfParkedCars++;
                            break;
                    }
                }

                if (numOfBuildings == 0) {
                    results[numOfParkedCars]++;
                }
            }
        }

        for (int result : results) {
            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
