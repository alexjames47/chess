package chess;

import java.util.Collection;
import java.util.HashSet;

public class RookMove extends PieceMoveCalculator implements PieceMove{
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        HashSet<ChessMove> myMoves = new HashSet<>();
        ChessPosition startingPosition = new ChessPosition(myPosition.getRow(),myPosition.getColumn());
        ChessPosition[] positionArray = new ChessPosition[]{startingPosition,myPosition};
        int[][] pieceDirections = rookDirections();
        for(int i = 0; i < 4; i++){
            while(withinBoard(positionArray[1],pieceDirections[i])){
                myMoves.add(pieceMoveCalculator(positionArray, pieceDirections[i], board));
                if(!board.SpaceIsEmpty(positionArray[1])){break;}
            }
            positionArray[1] = positionArray[0];
        }
        myMoves.remove(null);
        HashSet<ChessMove> queenMoves = new HashSet<>();
        for(ChessMove temp : myMoves){
            if(!endagersKing(temp,board)){
                queenMoves.add(temp);
            }
        }
        return queenMoves;
    }

    int[][] rookDirections(){
        int[][] directions = new int[4][2];

        directions[0][0] = -1;
        directions[0][1] = 0;  //S
        directions[1][0] = 1;
        directions[1][1] = 0;  //N
        directions[2][0] = 0;
        directions[2][1] = 1;  //E
        directions[3][0] = 0;
        directions[3][1] = -1; //W
        return directions;
    }
}
