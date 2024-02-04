package chess;

import java.util.Collection;
import java.util.HashSet;

public class KingEndagerCalculator {

    Collection<ChessMove> removeEndangeringMoves(Collection<ChessMove> chessMoves, ChessBoard board){
        HashSet<ChessMove> newMoves = new HashSet<>();
        for(ChessMove temp : chessMoves){
            if(doesNotEndangerKing(temp, board)){
                newMoves.add(temp);
            }
        }
        return newMoves;
    }

    boolean doesNotEndangerKing(ChessMove move, ChessBoard board){
        ChessBoard newBoard = new ChessBoard(board);
        ChessGame.TeamColor turn = board.GetSpaceColor(move.getStartPosition());
        int initRow = move.getStartPosition().getRow();
        int initCol = move.getStartPosition().getColumn();
        int newRow = move.getEndPosition().getRow();
        int newCol = move.getEndPosition().getColumn();
        newBoard.board[newRow-1][newCol-1] = board.board[initRow-1][initCol-1];
        newBoard.board[initRow-1][initCol-1] = null;

        boolean kingIsSafe = isKingSafe(newBoard, turn);
        return kingIsSafe;
    }

    boolean isKingSafe(ChessBoard newBoard, ChessGame.TeamColor turn){
        boolean kingIsSafe = true;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                ChessPosition temp = new ChessPosition(i+1,j+1);
                if(newBoard.board[i][j] != null && newBoard.getPiece(temp).getTeamColor() != turn) {
                    kingIsSafe = isKingSafeHelper(newBoard.getPiece(temp).myPieceMoves(newBoard, temp));
                    if (!kingIsSafe) break;
                }
            }
            if(!kingIsSafe) break;
        }
        return kingIsSafe;
    }

    boolean isKingSafeHelper(Collection<ChessMove> Moves){
        boolean kingIsSafe = true;
        for(ChessMove temp : Moves){
            if (temp.getHarassesKing()) {
                kingIsSafe = false;
                break;
            }
        }
        return kingIsSafe;
    }

}
