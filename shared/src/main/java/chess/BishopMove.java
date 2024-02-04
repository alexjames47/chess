package chess;

import java.util.Collection;
import java.util.HashSet;

public class BishopMove extends PieceMoveCalculator implements PieceMove{
    @Override
    public Collection<ChessMove> myPieceMoves(ChessBoard board, ChessPosition myPosition) {
        HashSet<ChessMove> myMoves = new HashSet<>();
        ChessPosition startingPosition = new ChessPosition(myPosition.getRow(),myPosition.getColumn());
        ChessPosition[] positionArray = new ChessPosition[]{startingPosition,myPosition};
        int[][] pieceDirections = bishopDirections();
        for(int i = 0; i < 4; i++){
            while(withinBoard(positionArray[1],pieceDirections[i])){
                myMoves.add(pieceMoveCalculator(positionArray, pieceDirections[i], board));
                if(!board.SpaceIsEmpty(positionArray[1])){break;}
            }
            positionArray[1] = positionArray[0];
        }
        myMoves.remove(null);
        HashSet<ChessMove> bishopMoves = new HashSet<>();
        return myMoves;
    }

    int[][] bishopDirections(){
        int[][] directions = new int[4][2];
        directions[0][0] = -1;
        directions[0][1] = -1; //SW
        directions[1][0] = -1;
        directions[1][1] = 1;  //SE
        directions[2][0] = 1;
        directions[2][1] = 1; //NE
        directions[3][0] = 1;
        directions[3][1] = -1; //NW
        return directions;
    }
}
