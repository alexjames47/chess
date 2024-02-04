package chess;

import java.util.Collection;
import java.util.HashSet;

public class KnightMove extends PieceMoveCalculator implements PieceMove{
    @Override
    public Collection<ChessMove> myPieceMoves(ChessBoard board, ChessPosition myPosition) {
        HashSet<ChessMove> myMoves = new HashSet<>();
        ChessPosition startingPosition = new ChessPosition(myPosition.getRow(),myPosition.getColumn());
        ChessPosition[] positionArray = new ChessPosition[]{startingPosition,myPosition};
        int[][] pieceDirections = knightDirections();
        for(int i = 0; i < 8; i++){
            if(withinBoard(positionArray[1],pieceDirections[i])){
                myMoves.add(pieceMoveCalculator(positionArray, pieceDirections[i], board));
            }
            positionArray[1] = positionArray[0];
        }
        myMoves.remove(null);
        return myMoves;
    }

    int[][] knightDirections(){
        int[][] directions = new int[8][2];
        directions[0][0] = -1;
        directions[0][1] = -2; //SW
        directions[1][0] = -2;
        directions[1][1] = -1;  //SW
        directions[2][0] = -1;
        directions[2][1] = 2;  //SE
        directions[3][0] = -2;
        directions[3][1] = 1;  //SE
        directions[4][0] = 1;
        directions[4][1] = 2; //NE
        directions[5][0] = 2;
        directions[5][1] = 1; //NE
        directions[6][0] = 1;
        directions[6][1] = -2;  //NW
        directions[7][0] = 2;
        directions[7][1] = -1; //NW
        return directions;
    }
}
