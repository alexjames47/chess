package chess;

import java.util.Collection;

/**
 * For a class that can manage a chess game, making moves on a board
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessGame {

    ChessBoard board;
    TeamColor turn = TeamColor.WHITE;
    public ChessGame() {
    }

    /**
     * @return Which team's turn it is
     */
    public TeamColor getTeamTurn() {
        return turn;
    }

    /**
     * Set's which teams turn it is
     *
     * @param team the team whose turn it is
     */
    public void setTeamTurn(TeamColor team) {
        turn = team;
    }

    /**
     * Enum identifying the 2 possible teams in a chess game
     */
    public enum TeamColor {
        WHITE,
        BLACK
    }

    /**
     * Gets a valid moves for a piece at the given location
     *
     * @param startPosition the piece to get valid moves for
     * @return Set of valid moves for requested piece, or null if no piece at
     * startPosition
     */
    public Collection<ChessMove> validMoves(ChessPosition startPosition) {
        Collection<ChessMove> Moves =  this.board.getPiece(startPosition).myPieceMoves(board, startPosition);
        KingEndagerCalculator temp = new KingEndagerCalculator();
        return temp.removeEndangeringMoves(Moves,board);
    }

    /**
     * Makes a move in a chess game
     *
     * @param move chess move to preform
     * @throws InvalidMoveException if move is invalid
     */
    public void makeMove(ChessMove move) throws InvalidMoveException {
        int endRow = move.getEndPosition().getRow();
        int endCol = move.getEndPosition().getColumn();
        int startRow = move.getStartPosition().getRow();
        int startCol = move.getStartPosition().getColumn();
        if(board.getBoard()[startRow-1][startCol-1] != null
                && validMoves(move.getStartPosition()).contains(move)
                && board.getBoard()[startRow-1][startCol-1].getTeamColor() == turn){
            if(move.getPromotionPiece() != null){
                ChessGame.TeamColor pieceColor = board.getBoard()[startRow-1][startCol-1].getTeamColor();
                board.getBoard()[endRow-1][endCol-1] = new ChessPiece(pieceColor, move.getPromotionPiece());
            } else {
                board.getBoard()[endRow-1][endCol-1] = board.getBoard()[startRow-1][startCol-1];
            }
            board.getBoard()[startRow-1][startCol-1] = null;
        } else {
            throw new InvalidMoveException();
        }
    }

    /**
     * Determines if the given team is in check
     *
     * @param teamColor which team to check for check
     * @return True if the specified team is in check
     */
    public boolean isInCheck(TeamColor teamColor) {
        KingEndagerCalculator temp = new KingEndagerCalculator();
        return !temp.isKingSafe(this.board,teamColor);
    }

    /**
     * Determines if the given team is in checkmate
     *
     * @param teamColor which team to check for checkmate
     * @return True if the specified team is in checkmate
     */
    public boolean isInCheckmate(TeamColor teamColor) {
        KingEndagerCalculator kingCalc = new KingEndagerCalculator();
        if(!isInCheck(teamColor)) {
            return false;
        }
        else {
            for(int row = 1; row < 9; row++){
                for(int col = 1; col < 9; col++){
                    ChessPosition position = new ChessPosition(row,col);
                    if(board.getBoard()[row-1][col-1] != null && board.getPiece(position).getTeamColor() == teamColor) {
                        Collection<ChessMove> temp;
                        temp = board.getPiece(position).pieceMoves(board,position);
                        for(ChessMove move : temp){
                            if(kingCalc.isKingNotEndangeredByMove(move, board)){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * Determines if the given team is in stalemate, which here is defined as having
     * no valid moves
     *
     * @param teamColor which team to check for stalemate
     * @return True if the specified team is in stalemate, otherwise false
     */
    public boolean isInStalemate(TeamColor teamColor) {
        KingEndagerCalculator kingCalc = new KingEndagerCalculator();
        if(!isInCheck(teamColor)) {
            for(int row = 1; row < 9; row++){
                for(int col = 1; col < 9; col++){
                    ChessPosition position = new ChessPosition(row,col);
                    if(board.getBoard()[row-1][col-1] != null && board.getPiece(position).getTeamColor() == teamColor) {
                        Collection<ChessMove> temp;
                        temp = board.getPiece(position).pieceMoves(board,position);
                        for(ChessMove move : temp){
                            if(kingCalc.isKingNotEndangeredByMove(move, board)){
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sets this game's chessboard with a given board
     *
     * @param board the new board to use
     */
    public void setBoard(ChessBoard board) {
        //throw new RuntimeException("Not implemented");
        this.board = new ChessBoard(board);
    }

    /**
     * Gets the current chessboard
     *
     * @return the chessboard
     */
    public ChessBoard getBoard() {
        return board;
    }
}
