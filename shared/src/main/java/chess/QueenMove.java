package chess;

import java.util.Collection;
import java.util.HashSet;

public class QueenMove implements PieceMove{
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        HashSet<ChessMove> myMoves = new HashSet<>();
        ChessPosition startingPosition = new ChessPosition(myPosition.getRow(),myPosition.getColumn());
        while(myPosition.getRow()-1>0 && myPosition.getColumn()-1>0)
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow()-1, myPosition.getColumn()-1);
            if(!board.SpaceIsEmpty(newPosition)){if(board.GetSpaceColor(startingPosition)==board.GetSpaceColor(newPosition)){break;}}
            ChessMove temp = new ChessMove(startingPosition,newPosition,null);
            myMoves.add(temp);
            myPosition = newPosition;
            if(!board.SpaceIsEmpty(myPosition)){break;}
        }
        myPosition = startingPosition;
        while(myPosition.getRow()-1>0 && myPosition.getColumn()+1<9)
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow()-1, myPosition.getColumn()+1);
            if(!board.SpaceIsEmpty(newPosition)){if(board.GetSpaceColor(startingPosition)==board.GetSpaceColor(newPosition)){break;}}
            ChessMove temp = new ChessMove(startingPosition,newPosition,null);
            myMoves.add(temp);
            myPosition = newPosition;
            if(!board.SpaceIsEmpty(myPosition)){break;}
        }
        myPosition = startingPosition;
        while(myPosition.getRow()+1<9 && myPosition.getColumn()+1<9)
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()+1);
            if(!board.SpaceIsEmpty(newPosition)){if(board.GetSpaceColor(startingPosition)==board.GetSpaceColor(newPosition)){break;}}
            ChessMove temp = new ChessMove(startingPosition,newPosition,null);
            myMoves.add(temp);
            myPosition = newPosition;
            if(!board.SpaceIsEmpty(myPosition)){break;}
        }
        myPosition = startingPosition;
        while(myPosition.getRow()+1<9 && myPosition.getColumn()-1>0)
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()-1);
            if(!board.SpaceIsEmpty(newPosition)){if(board.GetSpaceColor(startingPosition)==board.GetSpaceColor(newPosition)){break;}}
            ChessMove temp = new ChessMove(startingPosition,newPosition,null);
            myMoves.add(temp);
            myPosition = newPosition;
            if(!board.SpaceIsEmpty(myPosition)){break;}
        }
        myPosition = startingPosition;
        while(myPosition.getRow()-1>0) //N
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow()-1, myPosition.getColumn());
            if(!board.SpaceIsEmpty(newPosition)){if(board.GetSpaceColor(startingPosition)==board.GetSpaceColor(newPosition)){break;}}
            ChessMove temp = new ChessMove(startingPosition,newPosition,null);
            myMoves.add(temp);
            myPosition = newPosition;
            if(!board.SpaceIsEmpty(myPosition)){break;}
        }
        myPosition = startingPosition;
        while(myPosition.getRow()+1<9) //S
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn());
            if(!board.SpaceIsEmpty(newPosition)){if(board.GetSpaceColor(startingPosition)==board.GetSpaceColor(newPosition)){break;}}
            ChessMove temp = new ChessMove(startingPosition,newPosition,null);
            myMoves.add(temp);
            myPosition = newPosition;
            if(!board.SpaceIsEmpty(myPosition)){break;}
        }
        myPosition = startingPosition;
        while(myPosition.getColumn()+1<9) //E
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow(), myPosition.getColumn()+1);
            if(!board.SpaceIsEmpty(newPosition)){if(board.GetSpaceColor(startingPosition)==board.GetSpaceColor(newPosition)){break;}}
            ChessMove temp = new ChessMove(startingPosition,newPosition,null);
            myMoves.add(temp);
            myPosition = newPosition;
            if(!board.SpaceIsEmpty(myPosition)){break;}
        }
        myPosition = startingPosition;
        while(myPosition.getColumn()-1>0) //W
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow(), myPosition.getColumn()-1);
            if(!board.SpaceIsEmpty(newPosition)){if(board.GetSpaceColor(startingPosition)==board.GetSpaceColor(newPosition)){break;}}
            ChessMove temp = new ChessMove(startingPosition,newPosition,null);
            myMoves.add(temp);
            myPosition = newPosition;
            if(!board.SpaceIsEmpty(myPosition)){break;}
        }
        return myMoves;
    }
}
