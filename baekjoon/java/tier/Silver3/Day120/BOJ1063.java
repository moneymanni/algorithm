package Silver3.Day120;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String kingSquare = st.nextToken();
        String stoneSquare = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        Piece king = new Piece(kingSquare.charAt(0), Integer.parseInt(String.valueOf(kingSquare.charAt(1))));
        Piece stone = new Piece(stoneSquare.charAt(0), Integer.parseInt(String.valueOf(stoneSquare.charAt(1))));

        while (N-- > 0) {
            String command = br.readLine();
            if (king.canMove(command, stone)) {
                king.move(command);
                if (king.equals(stone)) {
                    stone.move(command);
                }
            }
        }

        bw.write(String.format("%s\n%s", king, stone));

        br.close();
        bw.flush();
        bw.close();
    }
    static class Piece {
        private char rank;
        private int file;

        public Piece(char rank, int file) {
            this.rank = rank;
            this.file = file;
        }

        public void move(String command) {
            int dRank = 0, dFile = 0;
            if (command.contains("R")) dRank = 1;
            if (command.contains("L")) dRank = -1;
            if (command.contains("B")) dFile = -1;
            if (command.contains("T")) dFile = 1;

            rank += dRank;
            file += dFile;
        }

        public boolean canMove(String command, Piece other) {
            int dRank = 0, dFile = 0;
            if (command.contains("R")) dRank = 1;
            if (command.contains("L")) dRank = -1;
            if (command.contains("B")) dFile = -1;
            if (command.contains("T")) dFile = 1;

            char newRank = (char) (rank + dRank);
            int newFile = file + dFile;

            if (newRank < 'A' || newRank > 'H' || newFile < 1 || newFile > 8)
                return false;

            if (other.getRank() == newRank && other.getFile() == newFile)
                return other.canMove(command, new Piece('Z', -1));

            return true;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Piece piece = (Piece) obj;
            return rank == piece.getRank() && file == piece.getFile();
        }

        @Override
        public String toString() {
            return String.format("%s%d", rank, file);
        }

        public char getRank() {
            return rank;
        }

        public int getFile() {
            return file;
        }
    }
}
