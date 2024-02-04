package chess;

import java.util.Collection;

public class PieceMoveCalculator {
    ChessMove pieceMoveCalculator(ChessPosition[] positionArray, int[] pieceDirections, ChessBoard board){

        ChessPosition startingPosition = positionArray[0];
        ChessPosition myPosition = positionArray[1];
        ChessPosition newPosition = new ChessPosition(myPosition.getRow()+pieceDirections[0], myPosition.getColumn()+pieceDirections[1]);

        if(!board.SpaceIsEmpty(newPosition)){
            if(board.GetSpaceColor(startingPosition)!=board.GetSpaceColor(newPosition)){
                ChessMove temp = new ChessMove(startingPosition,newPosition,null);
                if(board.getPiece(newPosition).getPieceType() == ChessPiece.PieceType.KING){
                    temp.setHarrassesKing();
                }
                positionArray[1] = newPosition;
                return temp;
            } else if (board.GetSpaceColor(startingPosition)==board.GetSpaceColor(newPosition)) {
                positionArray[1] = newPosition;
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

    boolean doesNotEndangerKing(ChessMove move, ChessBoard board){
        ChessBoard newBoard = new ChessBoard(board);
        ChessGame.TeamColor turn = board.GetSpaceColor(move.getStartPosition());
        int initRow = move.getStartPosition().getRow();
        int initCol = move.getStartPosition().getColumn();
        int newRow = move.getEndPosition().getRow();
        int newCol = move.getEndPosition().getColumn();
        newBoard.board[newRow][newCol] = board.board[initRow][initCol];
        newBoard.board[initRow][initCol] = null;

        boolean kingIsSafe = true;

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                ChessPosition temp = new ChessPosition(i,j);
                if(newBoard.getPiece(temp) != null && newBoard.getPiece(temp).getTeamColor() == turn){
                    kingIsSafe = doesNotEndangerKingHelper(board.getPiece(temp).pieceMoves(newBoard,temp));
                }
            }
        }
        return kingIsSafe;
    }

    boolean doesNotEndangerKingHelper(Collection<ChessMove> Moves){
        boolean kingIsSafe = true;
        for(ChessMove temp : Moves){
            if (temp.getHarrassesKing()) {
                kingIsSafe = false;
                break;
            }
        }
        return kingIsSafe;
    }
}
