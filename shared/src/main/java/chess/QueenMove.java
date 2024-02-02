package chess;

import java.util.Collection;
import java.util.HashSet;

public class QueenMove extends PieceMoveCalculator implements PieceMove {
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        HashSet<ChessMove> myMoves = new HashSet<>();
        ChessPosition startingPosition = new ChessPosition(myPosition.getRow(),myPosition.getColumn());
        ChessPosition[] positionArray = new ChessPosition[]{startingPosition,myPosition};
        int[][] pieceDirections = queenDirections();
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

    int[][] queenDirections(){
        int[][] queenDirections = new int[8][2];
        queenDirections[0][0] = -1;
        queenDirections[0][1] = -1; //SW
        queenDirections[1][0] = -1;
        queenDirections[1][1] = 1;  //SE
        queenDirections[2][0] = -1;
        queenDirections[2][1] = 0;  //S
        queenDirections[3][0] = 1;
        queenDirections[3][1] = 0;  //N
        queenDirections[4][0] = 1;
        queenDirections[4][1] = 1; //NE
        queenDirections[5][0] = 1;
        queenDirections[5][1] = -1; //NW
        queenDirections[6][0] = 0;
        queenDirections[6][1] = 1;  //E
        queenDirections[7][0] = 0;
        queenDirections[7][1] = -1; //W
        return queenDirections;
    }
}
