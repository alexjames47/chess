package chess;

import java.util.Collection;
import java.util.HashSet;

public class KingMove implements PieceMove{
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        HashSet<ChessMove> myMoves = new HashSet<>();
        ChessPosition startingPosition = new ChessPosition(myPosition.getRow(), myPosition.getColumn());
        if (myPosition.getRow() - 1 > 0 && myPosition.getColumn() - 1 > 0) // NW
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1);
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
        if (myPosition.getRow() - 1 > 0 && myPosition.getColumn() + 1 < 9) //NE
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1);
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
        if (myPosition.getRow() + 1 < 9 && myPosition.getColumn() + 1 < 9)  //SE
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1);
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
        if (myPosition.getRow() + 1 < 9 && myPosition.getColumn() - 1 > 0) //SW
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1);
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
        if (myPosition.getRow() - 1 > 0) //N
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn());
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
        if (myPosition.getRow() + 1 < 9) //S
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn());
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
        if (myPosition.getColumn() + 1 < 9) //E
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow(), myPosition.getColumn() + 1);
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
        if (myPosition.getColumn() - 1 > 0) //W
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow(), myPosition.getColumn() - 1);
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
