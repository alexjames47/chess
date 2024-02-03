package chess;


import java.util.Arrays;

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

    public ChessBoard(ChessBoard board) {
        this.board = board.getBoard().clone();
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

    public ChessPiece[][] getBoard(){
        return board;
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {
        //throw new RuntimeException("Not implemented");
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                board[i][j] = null;
            }
        }
        ChessGame.TeamColor temp = ChessGame.TeamColor.WHITE;
        int j = 1;
        for(int i = 0; i < 8; i++)
        {
            board[i][0] = new ChessPiece(temp, ChessPiece.PieceType.ROOK);
            board[i][0].pP = new ChessPosition(i+1,1);
            board[i][1] = new ChessPiece(temp, ChessPiece.PieceType.KNIGHT);
            board[i][1].pP = new ChessPosition(i+1,2);
            board[i][2] = new ChessPiece(temp, ChessPiece.PieceType.BISHOP);
            board[i][2].pP = new ChessPosition(i+1,3);
            board[i][3] = new ChessPiece(temp, ChessPiece.PieceType.QUEEN);
            board[i][3].pP = new ChessPosition(i+1,4);
            board[i][4] = new ChessPiece(temp, ChessPiece.PieceType.KING);
            board[i][4].pP = new ChessPosition(i+1,5);
            board[i][5] = new ChessPiece(temp, ChessPiece.PieceType.BISHOP);
            board[i][5].pP = new ChessPosition(i+1,6);
            board[i][6] = new ChessPiece(temp, ChessPiece.PieceType.KNIGHT);
            board[i][6].pP = new ChessPosition(i+1,7);
            board[i][7] = new ChessPiece(temp, ChessPiece.PieceType.ROOK);
            board[i][7].pP = new ChessPosition(i+1,8);
            for(int k = 0; k < 8; k++)
            {
                board[i+j][k] = new ChessPiece(temp, ChessPiece.PieceType.PAWN);
                board[i+j][k].pP = new ChessPosition(i+j+1,k+1);
            }
            i+=6;
            j-=2;
            temp = ChessGame.TeamColor.BLACK;
        }
        //j = 0;
    }

    public boolean SpaceIsEmpty(ChessPosition position)
    {
        var temp1 = position.getRow();
        var temp2 = position.getColumn();
        return board[temp1 - 1][temp2 - 1] == null;
    }

    public ChessGame.TeamColor GetSpaceColor(ChessPosition position)
    {
        var temp1 = position.getRow();
        var temp2 = position.getColumn();
        if(board[temp1-1][temp2-1] != null) return board[temp1-1][temp2-1].getTeamColor();
        throw new RuntimeException("No Piece Found");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChessBoard that)) return false;
        return Arrays.deepEquals(board, that.board);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }
}
