package chess;

import java.util.Collection;
import java.util.HashSet;

public class QueenMove extends PieceMoveCalculator implements PieceMove {
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        HashSet<ChessMove> myMoves = new HashSet<>();
        ChessPosition startingPosition = new ChessPosition(myPosition.getRow(),myPosition.getColumn());
        ChessPosition[] positionArray = new ChessPosition[]{startingPosition,myPosition};
        int[][] pieceDirections = queenDirections();
        for(int i = 0; i < 8; i++){
            while(withinBoard(positionArray[1],pieceDirections[i])){
                myMoves.add(pieceMoveCalculator(positionArray, pieceDirections, board));
            }
        }
        return myMoves;
    }

    int[][] queenDirections(){
        int[][] queenDirections = new int[8][2];
        queenDirections[0][0] = -1;
        queenDirections[0][1] = -1; //SW
        queenDirections[1][0] = -1;
        queenDirections[1][1] = 1;  //SE
        queenDirections[2][0] = -1;
        queenDirections[2][1] = 0;  //S
        queenDirections[3][0] = 1;
        queenDirections[3][1] = 0;  //N
        queenDirections[4][0] = 1;
        queenDirections[4][1] = 1; //NE
        queenDirections[5][0] = 1;
        queenDirections[5][1] = -1; //NW
        queenDirections[6][0] = 0;
        queenDirections[6][1] = 1;  //E
        queenDirections[7][0] = 0;
        queenDirections[7][1] = -1; //W
        return queenDirections;
    }
}
