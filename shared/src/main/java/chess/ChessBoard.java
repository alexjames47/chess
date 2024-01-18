package chess;

import java.util.ArrayList;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {

    //ArrayList<ChessPiece> cps = new ArrayList<>();

    ChessPiece[][] board = new ChessPiece[8][8];
    public ChessBoard() {

    }

    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece) {
        //throw new RuntimeException("Not implemented");
        ChessPiece temp = new ChessPiece(piece.getTeamColor(), piece.getPieceType());
        temp.pP = position;
        int r = position.getRow();
        int c = position.getColumn();
        board[r-1][c-1] = temp;
        //cps.add(temp);
    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        //throw new RuntimeException("Not implemented");
        var temp1 = position.getRow();
        var temp2 = position.getColumn();
        if(board[temp1-1][temp2-1] != null) return board[temp1-1][temp2-1];
        throw new RuntimeException("No Piece Found");
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {
        throw new RuntimeException("Not implemented");
    }

    public boolean SpaceIsEmpty(ChessPosition position)
    {
        var temp1 = position.getRow();
        var temp2 = position.getColumn();
        if(board[temp1-1][temp2-1] != null) return false;
        else return true;
    }

    public ChessGame.TeamColor GetSpaceColor(ChessPosition position)
    {
        var temp1 = position.getRow();
        var temp2 = position.getColumn();
        if(board[temp1-1][temp2-1] != null) return board[temp1-1][temp2-1].getTeamColor();
        throw new RuntimeException("No Piece Found");
    }
}
