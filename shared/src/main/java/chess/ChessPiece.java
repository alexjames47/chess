package chess;

import java.util.Collection;
import java.util.HashSet;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    ChessGame.TeamColor pC;
    ChessPiece.PieceType t;
    ChessPosition pP;
    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        pC = pieceColor;
        t = type;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        //throw new RuntimeException("Not implemented");
        return pC;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        //throw new RuntimeException("Not implemented");
        return t;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        //throw new RuntimeException("Not implemented");

        if (board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getPieceType() == PieceType.BISHOP)
        {return bishopMoves(board,myPosition);}
        if (board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getPieceType() == PieceType.KING)
        {return kingMoves(board,myPosition);}
        if (board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getPieceType() == PieceType.KNIGHT)
        {return knightMoves(board,myPosition);}
        if (board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getPieceType() == PieceType.PAWN)
        {return pawnMoves(board,myPosition);}
        if (board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getPieceType() == PieceType.QUEEN)
        {return queenMoves(board,myPosition);}
        if (board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getPieceType() == PieceType.ROOK)
        {return rookMoves(board,myPosition);}
        return null;
    }

    public Collection<ChessMove> bishopMoves(ChessBoard board, ChessPosition myPosition)
    {
        HashSet<ChessMove> myMoves = new HashSet<ChessMove>();
        ChessPosition startingPosition = new ChessPosition(myPosition.getRow(),myPosition.getColumn());
        while(myPosition.getRow()-1>0 && myPosition.getColumn()-1>0) //NW
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow()-1, myPosition.getColumn()-1);
            if(!board.SpaceIsEmpty(newPosition)){if(board.GetSpaceColor(startingPosition)==board.GetSpaceColor(newPosition)){break;}}
            ChessMove temp = new ChessMove(startingPosition,newPosition,null);
            myMoves.add(temp);
            myPosition = newPosition;
            if(!board.SpaceIsEmpty(myPosition)){break;}
        }
        myPosition = startingPosition;
        while(myPosition.getRow()-1>0 && myPosition.getColumn()+1<9) //NE
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow()-1, myPosition.getColumn()+1);
            if(!board.SpaceIsEmpty(newPosition)){if(board.GetSpaceColor(startingPosition)==board.GetSpaceColor(newPosition)){break;}}
            ChessMove temp = new ChessMove(startingPosition,newPosition,null);
            myMoves.add(temp);
            myPosition = newPosition;
            if(!board.SpaceIsEmpty(myPosition)){break;}
        }
        myPosition = startingPosition;
        while(myPosition.getRow()+1<9 && myPosition.getColumn()+1<9) //SE
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()+1);
            if(!board.SpaceIsEmpty(newPosition)){if(board.GetSpaceColor(startingPosition)==board.GetSpaceColor(newPosition)){break;}}
            ChessMove temp = new ChessMove(startingPosition,newPosition,null);
            myMoves.add(temp);
            myPosition = newPosition;
            if(!board.SpaceIsEmpty(myPosition)){break;}
        }
        myPosition = startingPosition;
        while(myPosition.getRow()+1<9 && myPosition.getColumn()-1>0) //SW
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()-1);
            if(!board.SpaceIsEmpty(newPosition)){if(board.GetSpaceColor(startingPosition)==board.GetSpaceColor(newPosition)){break;}}
            ChessMove temp = new ChessMove(startingPosition,newPosition,null);
            myMoves.add(temp);
            myPosition = newPosition;
            if(!board.SpaceIsEmpty(myPosition)){break;}
        }
        myPosition = startingPosition;
        return myMoves;
    }
    public Collection<ChessMove> kingMoves(ChessBoard board, ChessPosition myPosition) {
        HashSet<ChessMove> myMoves = new HashSet<ChessMove>();
        ChessPosition startingPosition = new ChessPosition(myPosition.getRow(), myPosition.getColumn());
        if (myPosition.getRow() - 1 > 0 && myPosition.getColumn() - 1 > 0) // NW
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)) {}
                else
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                myPosition = newPosition;
            }
        }
        myPosition = startingPosition;
        if (myPosition.getRow() - 1 > 0 && myPosition.getColumn() + 1 < 9) //NE
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)) {}
                else
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                myPosition = newPosition;
            }
        }
        myPosition = startingPosition;
        if (myPosition.getRow() + 1 < 9 && myPosition.getColumn() + 1 < 9)  //SE
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)) {}
                else
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                myPosition = newPosition;
            }
        }
        myPosition = startingPosition;
        if (myPosition.getRow() + 1 < 9 && myPosition.getColumn() - 1 > 0) //SW
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)) {}
                else
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                myPosition = newPosition;
            }
        }
        myPosition = startingPosition;
        if (myPosition.getRow() - 1 > 0) //N
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn());
            if (!board.SpaceIsEmpty(newPosition)) {
                if (board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)) {}
                else
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                myPosition = newPosition;
            }
        }
        myPosition = startingPosition;
        if (myPosition.getRow() + 1 < 9) //S
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn());
            if (!board.SpaceIsEmpty(newPosition)) {
                if (board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)) {}
                else
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                myPosition = newPosition;
            }
        }
        myPosition = startingPosition;
        if (myPosition.getColumn() + 1 < 9) //E
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow(), myPosition.getColumn() + 1);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)) {}
                else
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                myPosition = newPosition;
            }
        }
        myPosition = startingPosition;
        if (myPosition.getColumn() - 1 > 0) //W
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow(), myPosition.getColumn() - 1);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)) {}
                else
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                myPosition = newPosition;
            }
        }
        return myMoves;
    }
    public Collection<ChessMove> knightMoves(ChessBoard board, ChessPosition myPosition){
        HashSet<ChessMove> myMoves = new HashSet<ChessMove>();
        ChessPosition startingPosition = new ChessPosition(myPosition.getRow(), myPosition.getColumn());
        if (myPosition.getRow() + 2 < 9 && myPosition.getColumn() + 1 < 9)
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() + 2, myPosition.getColumn() + 1);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)) {}
                else
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                myPosition = newPosition;
            }
        }
        myPosition = startingPosition;
        if (myPosition.getRow() + 1 < 9 && myPosition.getColumn() + 2 < 9)
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 2);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)) {}
                else
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                myPosition = newPosition;
            }
        }
        myPosition = startingPosition;
        if (myPosition.getRow() - 1 > 0 && myPosition.getColumn() + 2 < 9)
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 2);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)) {}
                else
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                myPosition = newPosition;
            }
        }
        myPosition = startingPosition;
        if (myPosition.getRow() - 2 > 0 && myPosition.getColumn() + 1 < 9)
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() - 2, myPosition.getColumn() + 1);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)) {}
                else
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                myPosition = newPosition;
            }
        }
        myPosition = startingPosition;
        if (myPosition.getRow() - 2 > 0 && myPosition.getColumn() - 1 > 0)
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() - 2, myPosition.getColumn()-1);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)) {}
                else
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                myPosition = newPosition;
            }
        }
        myPosition = startingPosition;
        if (myPosition.getRow() - 1 > 0 && myPosition.getColumn() -2 > 0)
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn()-2);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)) {}
                else
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                myPosition = newPosition;
            }
        }
        myPosition = startingPosition;
        if (myPosition.getRow() + 1 < 9 && myPosition.getColumn() -2>0)
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn() -2);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)) {}
                else
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                myPosition = newPosition;
            }
        }
        myPosition = startingPosition;
        if (myPosition.getRow() + 2 < 9 && myPosition.getColumn() - 1 > 0)
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow()+2, myPosition.getColumn() - 1);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)) {}
                else
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
            }
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                myPosition = newPosition;
            }
        }
        return myMoves;
    }
    public Collection<ChessMove> pawnMoves(ChessBoard board, ChessPosition myPosition){
        if (board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getTeamColor() == ChessGame.TeamColor.WHITE)
        {return whitePawnMoves(board,myPosition);}
        else if(board.board[myPosition.getRow()-1][myPosition.getColumn()-1].getTeamColor() == ChessGame.TeamColor.BLACK)
        {return blackPawnMoves(board,myPosition);}
        return null;
    }

    public Collection<ChessMove> whitePawnMoves(ChessBoard board, ChessPosition myPosition)
    {
        HashSet<ChessMove> myMoves = new HashSet<ChessMove>();
        ChessPosition startingPosition = new ChessPosition(myPosition.getRow(), myPosition.getColumn());
        if (myPosition.getRow() + 1 > 0 && myPosition.getColumn() - 1 > 0) // SW
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)) {}
                else
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
            }
        }
        myPosition = startingPosition;
        if (myPosition.getRow() + 1 > 0 && myPosition.getColumn() + 1 < 9) //SE
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)) {}
                else
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
            }
        }
        myPosition = startingPosition;
        if (myPosition.getRow() + 1 > 0)  //S
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn());
            if (!board.SpaceIsEmpty(newPosition)) {}
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                myPosition = newPosition;
            }
        }
        myPosition = startingPosition;
        if (myPosition.getRow() == 2) //InitialMove
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() + 2, myPosition.getColumn());
            ChessPosition middlePosition = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn());
            if(board.SpaceIsEmpty(newPosition)&&board.SpaceIsEmpty(middlePosition))
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                myPosition = newPosition;
            }
        }
        myPosition = startingPosition;
        return myMoves;
    }

    public Collection<ChessMove> blackPawnMoves(ChessBoard board, ChessPosition myPosition)
    {
        HashSet<ChessMove> myMoves = new HashSet<ChessMove>();
        ChessPosition startingPosition = new ChessPosition(myPosition.getRow(), myPosition.getColumn());
        if (myPosition.getRow() - 1 > 0 && myPosition.getColumn() - 1 > 0) // NW
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)) {}
                else
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
            }
        }
        myPosition = startingPosition;
        if (myPosition.getRow() - 1 > 0 && myPosition.getColumn() + 1 < 9) //NE
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1);
            if (!board.SpaceIsEmpty(newPosition)) {
                if (board.GetSpaceColor(startingPosition) == board.GetSpaceColor(newPosition)) {}
                else
                {
                    ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                    myMoves.add(temp);
                    myPosition = newPosition;
                }
            }
        }
        myPosition = startingPosition;
        if (myPosition.getRow() - 1 > 0)  //N
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn());
            if (!board.SpaceIsEmpty(newPosition)) {}
            else
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                myPosition = newPosition;
            }
        }
        myPosition = startingPosition;
        if (myPosition.getRow() == 7) //InitialMove
        {
            ChessPosition newPosition = new ChessPosition(myPosition.getRow() - 2, myPosition.getColumn());
            ChessPosition middlePosition = new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn());
            if(board.SpaceIsEmpty(newPosition) && board.SpaceIsEmpty(middlePosition))
            {
                ChessMove temp = new ChessMove(startingPosition, newPosition, null);
                myMoves.add(temp);
                myPosition = newPosition;
            }
        }
        myPosition = startingPosition;
        return myMoves;
    }
    public Collection<ChessMove> queenMoves(ChessBoard board, ChessPosition myPosition)
    {
        HashSet<ChessMove> myMoves = new HashSet<ChessMove>();
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
    public Collection<ChessMove> rookMoves(ChessBoard board, ChessPosition myPosition)
    {
        HashSet<ChessMove> myMoves = new HashSet<ChessMove>();
        ChessPosition startingPosition = new ChessPosition(myPosition.getRow(),myPosition.getColumn());
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
        myPosition = startingPosition;
        return myMoves;
    }
}
