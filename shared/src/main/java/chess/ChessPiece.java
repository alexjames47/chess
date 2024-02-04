package chess;

import java.util.Collection;
//import java.util.HashSet;
import java.util.HashSet;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    ChessGame.TeamColor pC;
    ChessPiece.PieceType t;
    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        pC = pieceColor;
        t = type;
    }

    public ChessPiece(ChessPiece oldPiece){
        pC = oldPiece.getTeamColor();
        t = oldPiece.getPieceType();
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
        if (board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getPieceType() == PieceType.BISHOP) {
            BishopMove temp = new BishopMove();
        }
        else if (board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getPieceType() == PieceType.KING) {
            KingMove temp = new KingMove();
            return temp.pieceMoves(board,myPosition);
        }
        else if (board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getPieceType() == PieceType.KNIGHT) {
            KnightMove temp = new KnightMove();
            return temp.pieceMoves(board,myPosition);
        }
        else if (board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getPieceType() == PieceType.PAWN) {
            PawnMove temp = new PawnMove();
            return temp.pieceMoves(board,myPosition);
        }
        else if (board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getPieceType() == PieceType.QUEEN) {
            QueenMove temp = new QueenMove();
            return temp.pieceMoves(board,myPosition);
        }
        else if (board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getPieceType() == PieceType.ROOK) {
            RookMove temp = new RookMove();
            return removeEndangeringMoves(temp.pieceMoves(board,myPosition),board);
        }
        return null;
    }

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

        boolean kingIsSafe = true;

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                ChessPosition temp = new ChessPosition(i+1,j+1);
                if(newBoard.board[i][j] != null && newBoard.getPiece(temp).getTeamColor() != turn){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChessPiece that)) return false;
        return pC == that.pC && t == that.t;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pC, t);
    }

    @Override
    public String toString() {
        return "ChessPiece{" +
                "pC=" + pC +
                ", t=" + t +
                '}';
    }
}
