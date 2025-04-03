package StepByStep.Advanced1;

import java.util.Scanner;

public class BOJ3003 {

    private static final int KING_CNT = 1;
    private static final int QUEEN_CNT = 1;
    private static final int ROOK_CNT = 2;
    private static final int BISHOP_CNT = 2;
    private static final int KNIGHT_CNT = 2;
    private static final int PAWN_CNT = 8;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int kingCnt = sc.nextInt();
        int queenCnt = sc.nextInt();
        int rookCnt = sc.nextInt();
        int bishopCnt = sc.nextInt();
        int knightCnt = sc.nextInt();
        int pawnCnt = sc.nextInt();

        System.out.printf("%d %d %d %d %d %d\n",
                getPiece(kingCnt, KING_CNT),
                getPiece(queenCnt, QUEEN_CNT),
                getPiece(rookCnt, ROOK_CNT),
                getPiece(bishopCnt, BISHOP_CNT),
                getPiece(knightCnt, KNIGHT_CNT),
                getPiece(pawnCnt, PAWN_CNT));
    }

    private static int getPiece(int ownedCnt, int pieceCnt) {
        return pieceCnt - ownedCnt;
    }
}
