package chess;

import java.util.HashSet;

public class PieceMoveCalculator {
    ChessMove pieceMoveCalculator(ChessPosition[] positionArray, int[][] pieceDirections, ChessBoard board){

        ChessPosition startingPosition = positionArray[0];
        ChessPosition myPosition = positionArray[1];

        ChessPosition newPosition = new ChessPosition(myPosition.getRow()-1, myPosition.getColumn()-1);
        if(!board.SpaceIsEmpty(newPosition)){
            if(board.GetSpaceColor(startingPosition)!=board.GetSpaceColor(newPosition)){
                positionArray[0] = newPosition;
                return new ChessMove(startingPosition,newPosition,null);
            } else if (board.GetSpaceColor(startingPosition)==board.GetSpaceColor(newPosition)) {
                return null;
            }
        } else if (board.SpaceIsEmpty(newPosition)) {
            positionArray[1] = newPosition;
            return new ChessMove(startingPosition,newPosition,null);
        }
        return null;
    }

    boolean withinBoard(ChessPosition myPosition, int[] pieceDirection){
        return (myPosition.getRow() + pieceDirection[0] < 9
                && myPosition.getRow() + pieceDirection[0] > 0
                && myPosition.getColumn() + pieceDirection[1] < 9
                && myPosition.getColumn() + pieceDirection[1] > 0);
    }
}
