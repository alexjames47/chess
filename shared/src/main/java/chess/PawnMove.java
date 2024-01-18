package chess;

import java.util.Collection;
import java.util.HashSet;

public class PawnMove implements PieceMove{
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        if (board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getTeamColor() == ChessGame.TeamColor.WHITE)
        {return whitePawnMoves(board,myPosition);}
        else if(board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getTeamColor() == ChessGame.TeamColor.BLACK)
        {return blackPawnMoves(board,myPosition);}
        throw new RuntimeException("Invalid Pawn");
    }
    public Collection<ChessMove> whitePawnMoves(ChessBoard board, ChessPosition myPosition)
    {
        HashSet<ChessMove> myMoves = new HashSet<>();
        ChessPosition startingPosition = new ChessPosition(myPosition.getRow(), myPosition.getColumn());
        if (myPosition.getRow() + 1 > 0 && myPosition.getColumn() - 1 > 0) // SW
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (!(board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)))
                {
                    if(newPosition.getRow() == 8)
                    {
                        ChessMove temp1 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.QUEEN);
                        myMoves.add(temp1);
                        ChessMove temp2 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.KNIGHT);
                        myMoves.add(temp2);
                        ChessMove temp3 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.ROOK);
                        myMoves.add(temp3);
                        ChessMove temp4 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.BISHOP);
                        myMoves.add(temp4);
                        //myPosition = newPosition;
                    }
                    else
                    {
                        ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                        myMoves.add(temp);
                        //myPosition = newPosition;
                    }
                }
            }
        }
        myPosition = startingPosition;
        if (myPosition.getRow() + 1 > 0 && myPosition.getColumn() + 1 < 9) //SE
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (!(board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)))
                {
                    if(newPosition.getRow() == 8)
                    {
                        ChessMove temp1 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.QUEEN);
                        myMoves.add(temp1);
                        ChessMove temp2 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.KNIGHT);
                        myMoves.add(temp2);
                        ChessMove temp3 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.ROOK);
                        myMoves.add(temp3);
                        ChessMove temp4 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.BISHOP);
                        myMoves.add(temp4);
                        //myPosition = newPosition;
                    }
                    else
                    {
                        ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                        myMoves.add(temp);
                        //myPosition = newPosition;
                    }
                }
            }
        }
        //myPosition = startingPosition;
        if (myPosition.getRow() + 1 > 0)  //S
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn());
            if (board.SpaceIsEmpty(newPosition))
            {
                if(newPosition.getRow() == 8)
                {
                    ChessMove temp1 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.QUEEN);
                    myMoves.add(temp1);
                    ChessMove temp2 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.KNIGHT);
                    myMoves.add(temp2);
                    ChessMove temp3 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.ROOK);
                    myMoves.add(temp3);
                    ChessMove temp4 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.BISHOP);
                    myMoves.add(temp4);
                    //myPosition = newPosition;
                }
                else
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    //myPosition = newPosition;
                }
            }
        }
        //myPosition = startingPosition;
        if (myPosition.getRow() == 2) //InitialMove
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() + 2, myPosition.getColumn());
            ChessPosition middlePosition = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn());
            if(board.SpaceIsEmpty(newPosition)&&board.SpaceIsEmpty(middlePosition))
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                //myPosition = newPosition;
            }
        }
        //myPosition = startingPosition;
        return myMoves;
    }

    public Collection<ChessMove> blackPawnMoves(ChessBoard board, ChessPosition myPosition)
    {
        HashSet<ChessMove> myMoves = new HashSet<>();
        ChessPosition startingPosition = new ChessPosition(myPosition.getRow(), myPosition.getColumn());
        if (myPosition.getRow() - 1 > 0 && myPosition.getColumn() - 1 > 0) // NW
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (!(board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)))
                {
                    if(newPosition.getRow() == 1)
                    {
                        ChessMove temp1 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.QUEEN);
                        myMoves.add(temp1);
                        ChessMove temp2 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.KNIGHT);
                        myMoves.add(temp2);
                        ChessMove temp3 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.ROOK);
                        myMoves.add(temp3);
                        ChessMove temp4 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.BISHOP);
                        myMoves.add(temp4);
                        //myPosition = newPosition;
                    }
                    else
                    {
                        ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                        myMoves.add(temp);
                        //myPosition = newPosition;
                    }
                }
            }
        }
        myPosition = startingPosition;
        if (myPosition.getRow() - 1 > 0 && myPosition.getColumn() + 1 < 9) //NE
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (!(board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)))
                {
                    if(newPosition.getRow() == 1)
                    {
                        ChessMove temp1 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.QUEEN);
                        myMoves.add(temp1);
                        ChessMove temp2 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.KNIGHT);
                        myMoves.add(temp2);
                        ChessMove temp3 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.ROOK);
                        myMoves.add(temp3);
                        ChessMove temp4 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.BISHOP);
                        myMoves.add(temp4);
                        //myPosition = newPosition;
                    }
                    else
                    {
                        ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                        myMoves.add(temp);
                        //myPosition = newPosition;
                    }
                }
            }
        }
        //myPosition = startingPosition;
        if (myPosition.getRow() - 1 > 0)  //N
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn());
            if (board.SpaceIsEmpty(newPosition))
            {
                if(newPosition.getRow() == 1)
                {
                    ChessMove temp1 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.QUEEN);
                    myMoves.add(temp1);
                    ChessMove temp2 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.KNIGHT);
                    myMoves.add(temp2);
                    ChessMove temp3 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.ROOK);
                    myMoves.add(temp3);
                    ChessMove temp4 = new ChessMove(startingPosition, newPosition, ChessPiece.PieceType.BISHOP);
                    myMoves.add(temp4);
                    //myPosition = newPosition;
                }
                else
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    //myPosition = newPosition;
                }
            }
        }
        //myPosition = startingPosition;
        if (myPosition.getRow() == 7) //InitialMove
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() - 2, myPosition.getColumn());
            ChessPosition middlePosition = new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn());
            if(board.SpaceIsEmpty(newPosition) && board.SpaceIsEmpty(middlePosition))
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                //myPosition = newPosition;
            }
        }
        //myPosition = startingPosition;
        return myMoves;
    }
}
