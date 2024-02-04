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
        for(int i = 0; i < 8; i++){
            while(withinBoard(positionArray[1],pieceDirections[i])){
                myMoves.add(pieceMoveCalculator(positionArray, pieceDirections[i], board));
                if(!board.SpaceIsEmpty(positionArray[1])){break;}
            }
            positionArray[1] = positionArray[0];
        }
        myMoves.remove(null);
        return myMoves;
    }

    int[][] queenDirections(){
        int[][] directions = new int[8][2];
        directions[0][0] = -1;
        directions[0][1] = -1; //SW
        directions[1][0] = -1;
        directions[1][1] = 1;  //SE
        directions[2][0] = -1;
        directions[2][1] = 0;  //S
        directions[3][0] = 1;
        directions[3][1] = 0;  //N
        directions[4][0] = 1;
        directions[4][1] = 1; //NE
        directions[5][0] = 1;
        directions[5][1] = -1; //NW
        directions[6][0] = 0;
        directions[6][1] = 1;  //E
        directions[7][0] = 0;
        directions[7][1] = -1; //W
        return directions;
    }
}
