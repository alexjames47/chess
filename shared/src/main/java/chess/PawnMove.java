package chess;

import java.util.Collection;
import java.util.HashSet;

public class PawnMove extends PieceMoveCalculator implements PieceMove{
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        if (board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getTeamColor() == ChessGame.TeamColor.WHITE) {
            return whitePawnMoves(board,myPosition);
        }
        else if(board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getTeamColor() == ChessGame.TeamColor.BLACK) {
            return blackPawnMoves(board,myPosition);
        }
        throw new RuntimeException("Invalid Pawn");
    }
    public Collection<ChessMove> whitePawnMoves(ChessBoard board, ChessPosition myPosition)
    {
        HashSet<ChessMove> myMoves = new HashSet<>();
        ChessPosition startingPosition = new ChessPosition(myPosition.getRow(),myPosition.getColumn());
        ChessPosition[] positionArray = new ChessPosition[]{startingPosition,myPosition};
        int[][] pieceDirections = whitePawnDirections();
        for(int i = 0; i < 3; i++){
            if(withinBoard(positionArray[1],pieceDirections[i])){
                if(whitePawnCanMove(board, i, positionArray[1])){
                    myMoves.add(pieceMoveCalculator(positionArray, pieceDirections[i], board));
                    if(i == 0 && !myMoves.contains(null) && startingPosition.getRow() == 2 && board.SpaceIsEmpty(positionArray[1].modPosition(1,0))) {
                        myMoves.add(pieceMoveCalculator(positionArray, pieceDirections[i], board));
                    }
                }
            }
            positionArray[1] = positionArray[0];
        }
        myMoves.remove(null);
        HashSet<ChessMove> pawnMoves = new HashSet<>();
        for(ChessMove temp : myMoves){
            if(temp.getEndPosition().getRow() == 1 || temp.getEndPosition().getRow() == 8){
                pawnMoves.add(new ChessMove(temp.getStartPosition(),temp.getEndPosition(), ChessPiece.PieceType.BISHOP));
                pawnMoves.add(new ChessMove(temp.getStartPosition(),temp.getEndPosition(), ChessPiece.PieceType.KNIGHT));
                pawnMoves.add(new ChessMove(temp.getStartPosition(),temp.getEndPosition(), ChessPiece.PieceType.ROOK));
                pawnMoves.add(new ChessMove(temp.getStartPosition(),temp.getEndPosition(), ChessPiece.PieceType.QUEEN));
            }
            else{
                pawnMoves.add(temp);
            }
        }
        return pawnMoves;
    }

    public Collection<ChessMove> blackPawnMoves(ChessBoard board, ChessPosition myPosition)
    {
        HashSet<ChessMove> myMoves = new HashSet<>();
        ChessPosition startingPosition = new ChessPosition(myPosition.getRow(),myPosition.getColumn());
        ChessPosition[] positionArray = new ChessPosition[]{startingPosition,myPosition};
        int[][] pieceDirections = blackPawnDirections();
        for(int i = 0; i < 3; i++){
            if(withinBoard(positionArray[1],pieceDirections[i])){
                if(blackPawnCanMove(board, i, positionArray[1])){
                    myMoves.add(pieceMoveCalculator(positionArray, pieceDirections[i], board));
                    if(i == 0 && !myMoves.contains(null) && startingPosition.getRow() == 7 && board.SpaceIsEmpty(positionArray[1].modPosition(-1,0))) {
                        myMoves.add(pieceMoveCalculator(positionArray, pieceDirections[i], board));
                    }
                }
            }
            positionArray[1] = positionArray[0];
        }
        myMoves.remove(null);
        HashSet<ChessMove> pawnMoves = new HashSet<>();
        for(ChessMove temp : myMoves){
            if(doesNotEndangerKing(temp, board)){
                if((temp.getEndPosition().getRow() == 1 || temp.getEndPosition().getRow() == 8)){
                    pawnMoves.add(new ChessMove(temp.getStartPosition(),temp.getEndPosition(), ChessPiece.PieceType.BISHOP));
                    pawnMoves.add(new ChessMove(temp.getStartPosition(),temp.getEndPosition(), ChessPiece.PieceType.KNIGHT));
                    pawnMoves.add(new ChessMove(temp.getStartPosition(),temp.getEndPosition(), ChessPiece.PieceType.ROOK));
                    pawnMoves.add(new ChessMove(temp.getStartPosition(),temp.getEndPosition(), ChessPiece.PieceType.QUEEN));
                }
                else{
                    pawnMoves.add(temp);
                }
            }
        }
        return pawnMoves;
    }



    int[][] whitePawnDirections(){
        int[][] directions = new int[3][2];
        directions[0][0] = 1;
        directions[0][1] = 0;  //N
        directions[1][0] = 1;
        directions[1][1] = 1; //NE
        directions[2][0] = 1;
        directions[2][1] = -1; //NW
        return directions;
    }

    int[][] blackPawnDirections(){
        int[][] directions = new int[3][2];
        directions[0][0] = -1;
        directions[0][1] = 0;  //S
        directions[1][0] = -1;
        directions[1][1] = -1; //SW
        directions[2][0] = -1;
        directions[2][1] = 1;  //SE
        return directions;
    }

    boolean whitePawnCanMove(ChessBoard board, int i, ChessPosition position){
        return ((i == 2 && !board.SpaceIsEmpty(position.modPosition(1,-1)))
                || (i == 1 && !board.SpaceIsEmpty(position.modPosition(1,1)))
                || (i == 0 && board.SpaceIsEmpty(position.modPosition(1,0))));
    }

    boolean blackPawnCanMove(ChessBoard board, int i, ChessPosition position){
        return ((i == 2 && !board.SpaceIsEmpty(position.modPosition(-1,1)))
                || (i == 1 && !board.SpaceIsEmpty(position.modPosition(-1,-1)))
                || (i == 0 && board.SpaceIsEmpty(position.modPosition(-1,0))));
    }
}
