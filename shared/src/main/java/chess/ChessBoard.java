package chess;


import java.util.Arrays;
import java.util.HashSet;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {

    ChessPiece[][] board = new ChessPiece[8][8];
    public ChessBoard() {

    }

    public ChessBoard(ChessBoard oldBoard) {
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if (oldBoard.getBoard()[i][j] != null) {
                    this.board[i][j] = new ChessPiece(oldBoard.getBoard()[i][j]);
                }
            }
        }
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
        var temp1 = position.getRow();
        var temp2 = position.getColumn();
        if(board[temp1-1][temp2-1] != null) {
            return board[temp1-1][temp2-1];
        }
        return null;
    }

    public HashSet<ChessPiece> findPiece(ChessGame.TeamColor color, ChessPiece.PieceType type) {
        HashSet<ChessPiece> temp = new HashSet<>();
        for(int i = 7; i >= 0; i--)
        {
            for(int j = 0; j < 8; j++)
            {
                if(board[i][j] != null && board[i][j].getPieceType() == type){
                    temp.add(board[i][j]);
                }
            }
        }
        return temp;
    }

    public HashSet<ChessPosition> findPosition(ChessGame.TeamColor color, ChessPiece.PieceType type) {
        HashSet<ChessPosition> temp = new HashSet<>();
        for(int i = 7; i >= 0; i--)
        {
            for(int j = 0; j < 8; j++)
            {
                if(board[i][j] != null && board[i][j].getPieceType() == type){
                    temp.add(new ChessPosition(i+1,j+1));
                }
            }
        }
        return temp;
    }

    public int[] findRowAndCol(ChessGame.TeamColor color, ChessPiece.PieceType type){
        int[] rowAndCol = new int[20];
        HashSet<ChessPosition> positions = findPosition(color,type);
        int counter = 0;
        for(ChessPosition temp : positions){
            rowAndCol[counter] = temp.getRow();
            rowAndCol[counter+1] = temp.getColumn();
            counter += 2;
        }
        return rowAndCol;
    }

    public boolean isClearBetweenPositions(ChessPosition kingPosition, ChessPosition rookPosition){
        int kingCol = kingPosition.getColumn();
        int rookCol = rookPosition.getColumn();
        int counter = kingCol+1;
        while(counter != rookCol){
            if(board[kingPosition.getRow()][counter] != null) return false;
            if(kingCol > rookCol) counter--;
            if(kingCol < rookCol) counter++;
        }
        return true;
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
            board[i][1] = new ChessPiece(temp, ChessPiece.PieceType.KNIGHT);
            board[i][2] = new ChessPiece(temp, ChessPiece.PieceType.BISHOP);
            board[i][3] = new ChessPiece(temp, ChessPiece.PieceType.QUEEN);
            board[i][4] = new ChessPiece(temp, ChessPiece.PieceType.KING);
            board[i][5] = new ChessPiece(temp, ChessPiece.PieceType.BISHOP);
            board[i][6] = new ChessPiece(temp, ChessPiece.PieceType.KNIGHT);
            board[i][7] = new ChessPiece(temp, ChessPiece.PieceType.ROOK);
            for(int k = 0; k < 8; k++)
            {
                board[i+j][k] = new ChessPiece(temp, ChessPiece.PieceType.PAWN);
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

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        temp.append("\n\n");
        for(int i = 7; i >= 0; i--)
        {
            temp.append(i+1);
            temp.append("  ");
            for(int j = 0; j < 8; j++)
            {
                if(board[i][j] == null){
                    temp.append(" || ");
                }
                else{
                    temp.append(" ").append(board[i][j].tinyToString()).append(" ");
                }
            }
            temp.append("\n");
        }
        temp.append("     1   2   3   4   5   6   7   8\n");
        return temp.toString();
    }
}
