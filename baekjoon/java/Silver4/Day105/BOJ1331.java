package Silver4.Day105;

import java.io.*;

public class BOJ1331 {
    public static final int NUM_OF_ROUTES = 36;
    public static final int NUM_OF_FILE = 6;
    public static final int NUM_OF_RANK = 6;

    public static String[][] chessboard;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] routes = new String[NUM_OF_ROUTES];
        for (int i = 0; i < NUM_OF_ROUTES; i++)
            routes[i] = br.readLine();

        makeChessboard();

        String prev = routes[0];
        visited[findSquare(prev)[0]][findSquare(prev)[1]] = true;
        boolean isNightTour = true;

        for (int i = 1; i < NUM_OF_ROUTES; i++) {
            if (!isNightTourRoute(prev, routes[i])) {
                isNightTour = false;
                break;
            }
            prev = routes[i];
            visited[findSquare(routes[i])[0]][findSquare(routes[i])[1]] = true;
        }

        for (int i = 0; i < NUM_OF_RANK; i++) {
            for (int j = 0; j < NUM_OF_FILE; j++) {
                if (!visited[i][j]) {
                    isNightTour = false;
                    break;
                }
            }
            if (!isNightTour) break;
        }

        if (isNightTour && isNightTourRoute(routes[NUM_OF_ROUTES - 1], routes[0]))
            bw.write("Valid");
        else
            bw.write("Invalid");

        br.close();
        bw.flush();
        bw.close();
    }

    static boolean isNightTourRoute(String prevSquare, String currSquare) {
        int[] prev = findSquare(prevSquare);
        int[] curr = findSquare(currSquare);

        if ((Math.abs(prev[0] - curr[0]) == 2 && Math.abs(prev[1] - curr[1]) == 1)
                || (Math.abs(prev[0] - curr[0]) == 1 && Math.abs(prev[1] - curr[1]) == 2))
            return true;
        else
            return false;
    }

    static int[] findSquare(String square) {
        int file = -1, rank = -1;

        switch (square.charAt(0)) {
            case 'A': file = 0; break;
            case 'B': file = 1; break;
            case 'C': file = 2; break;
            case 'D': file = 3; break;
            case 'E': file = 4; break;
            case 'F': file = 5; break;
        }
        rank = (square.charAt(1) - '0') - 1;

        return new int[]{file, rank};
    }

    static void makeChessboard() {
        chessboard = new String[NUM_OF_RANK][NUM_OF_FILE];
        visited = new boolean[NUM_OF_RANK][NUM_OF_FILE];

        char[] alphabets = {'A', 'B', 'C', 'D', 'E', 'F'};

        for (int i = 0; i < NUM_OF_RANK; i++) {
            for (int j = 0; j < NUM_OF_FILE; j++) {
                chessboard[i][j] = String.valueOf(alphabets[j]) + (i + 1);
            }
        }
    }
}
