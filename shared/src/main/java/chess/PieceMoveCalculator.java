package chess;

import java.util.HashSet;

public class PieceMoveCalculator {
    ChessMove pieceMovesCalculator(ChessPosition[] positionArray, int[][] pieceDirections, ChessBoard board){

        ChessPosition startingPosition = positionArray[0];
        ChessPosition myPosition = positionArray[1];

        ChessPosition newPosition = new ChessPosition(myPosition.getRow()-1, myPosition.getColumn()-1);
        if(!board.SpaceIsEmpty(newPosition)){
            if(board.GetSpaceColor(startingPosition)!=board.GetSpaceColor(newPosition)){
                return new ChessMove(startingPosition,newPosition,null);
            } else if (board.GetSpaceColor(startingPosition)==board.GetSpaceColor(newPosition)) {
                return null;
            }
        } else if (board.SpaceIsEmpty(newPosition)) {
            return new ChessMove(startingPosition,newPosition,null);
        }
        return null;
    }
}
