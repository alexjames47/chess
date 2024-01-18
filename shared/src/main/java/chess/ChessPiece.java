package chess;

import java.util.Collection;
import java.util.HashSet;
import java.util.Vector;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    ChessGame.TeamColor pC;
    ChessPiece.PieceType t;
    ChessPosition pP;
    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        pC = pieceColor;
        t = type;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        //throw new RuntimeException("Not implemented");
        return pC;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        //throw new RuntimeException("Not implemented");
        return t;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        //throw new RuntimeException("Not implemented");
        HashSet<ChessMove> myMoves = new HashSet<ChessMove>();
        if (board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getPieceType() == PieceType.BISHOP)
        {
            ChessPosition startingPosition = new ChessPosition(myPosition.getRow(),myPosition.getColumn());
            boolean checkDirections = true;
            while(checkDirections)
            {
                if(myPosition.getRow()-1>0 && myPosition.getColumn()-1>0)
                {
                    ChessPosition newPosition = new ChessPosition(myPosition.getRow()-1, myPosition.getColumn()-1);
                    ChessMove temp = new ChessMove(startingPosition,newPosition,null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
                else checkDirections = false;
            }
            myPosition = startingPosition;
            checkDirections = true;
            while(checkDirections)
            {
                if(myPosition.getRow()-1>0 && myPosition.getColumn()+1<9)
                {
                    ChessPosition newPosition = new ChessPosition(myPosition.getRow()-1, myPosition.getColumn()+1);
                    ChessMove temp = new ChessMove(startingPosition,newPosition,null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
                else checkDirections = false;
            }
            myPosition = startingPosition;
            checkDirections = true;
            while(checkDirections)
            {
                if(myPosition.getRow()+1<9 && myPosition.getColumn()+1<9)
                {
                    ChessPosition newPosition = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()+1);
                    ChessMove temp = new ChessMove(startingPosition,newPosition,null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
                else checkDirections = false;
            }
            myPosition = startingPosition;
            checkDirections = true;
            while(checkDirections)
            {
                if(myPosition.getRow()+1<9 && myPosition.getColumn()-1>0)
                {
                    ChessPosition newPosition = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()-1);
                    ChessMove temp = new ChessMove(startingPosition,newPosition,null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
                else checkDirections = false;
            }
            myPosition = startingPosition;
        }
        return myMoves;
    }
}
