package chess;

import java.util.Collection;
import java.util.HashSet;

public class KnightMove implements PieceMove{
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        HashSet<ChessMove> myMoves = new HashSet<>();
        ChessPosition startingPosition = new ChessPosition(myPosition.getRow(), myPosition.getColumn());
        if (myPosition.getRow() + 2 < 9 && myPosition.getColumn() + 1 < 9)
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() + 2, myPosition.getColumn() + 1);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (!(board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)))
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    //myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                //myPosition = newPosition;
            }
        }
        myPosition = startingPosition;
        if (myPosition.getRow() + 1 < 9 && myPosition.getColumn() + 2 < 9)
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 2);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (!(board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)))
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    //myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                //myPosition = newPosition;
            }
        }
        //myPosition = startingPosition;
        if (myPosition.getRow() - 1 > 0 && myPosition.getColumn() + 2 < 9)
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 2);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (!(board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)))
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    //myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                //myPosition = newPosition;
            }
        }
        //myPosition = startingPosition;
        if (myPosition.getRow() - 2 > 0 && myPosition.getColumn() + 1 < 9)
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() - 2, myPosition.getColumn() + 1);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (!(board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)))
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    //myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                //myPosition = newPosition;
            }
        }
        //myPosition = startingPosition;
        if (myPosition.getRow() - 2 > 0 && myPosition.getColumn() - 1 > 0)
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() - 2, myPosition.getColumn()-1);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (!(board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)))
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    //myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                //myPosition = newPosition;
            }
        }
        //myPosition = startingPosition;
        if (myPosition.getRow() - 1 > 0 && myPosition.getColumn() -2 > 0)
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn()-2);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (!(board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)))
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    //myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                //myPosition = newPosition;
            }
        }
        //myPosition = startingPosition;
        if (myPosition.getRow() + 1 < 9 && myPosition.getColumn() -2>0)
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn() -2);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (!(board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)))
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    //myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                //myPosition = newPosition;
            }
        }
        //myPosition = startingPosition;
        if (myPosition.getRow() + 2 < 9 && myPosition.getColumn() - 1 > 0)
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow()+2, myPosition.getColumn() - 1);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (!(board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)))
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    //myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                //myPosition = newPosition;
            }
        }
        return myMoves;
    }
}
