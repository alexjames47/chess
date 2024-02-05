package chess;

import java.util.Collection;
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

    boolean hasMoved = false;

    boolean canBeEnPassant = false;
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

    public void setHasMoved() {
        this.hasMoved = true;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        return myPieceMoves(board, myPosition);
    }

    public Collection<ChessMove> myPieceMoves(ChessBoard board, ChessPosition myPosition) {
        //throw new RuntimeException("Not implemented");
        if (board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getPieceType() == PieceType.BISHOP) {
            BishopMove temp = new BishopMove();
            return temp.myPieceMoves(board,myPosition);
        }
        else if (board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getPieceType() == PieceType.KING) {
            KingMove temp = new KingMove();
            return temp.myPieceMoves(board,myPosition);
        }
        else if (board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getPieceType() == PieceType.KNIGHT) {
            KnightMove temp = new KnightMove();
            return temp.myPieceMoves(board,myPosition);
        }
        else if (board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getPieceType() == PieceType.PAWN) {
            PawnMove temp = new PawnMove();
            return temp.myPieceMoves(board,myPosition);
        }
        else if (board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getPieceType() == PieceType.QUEEN) {
            QueenMove temp = new QueenMove();
            return temp.myPieceMoves(board,myPosition);
        }
        else if (board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getPieceType() == PieceType.ROOK) {
            RookMove temp = new RookMove();
            return temp.myPieceMoves(board,myPosition);
        }
        return null;
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

    public String tinyToString(){
        if(pC == ChessGame.TeamColor.WHITE){
            return t.name().substring(0,2);
        }
        return t.name().substring(0,2).toLowerCase();
    }

    @Override
    public String toString() {
        return "ChessPiece{" +
                "pC=" + pC +
                ", t=" + t +
                '}';
    }
}
