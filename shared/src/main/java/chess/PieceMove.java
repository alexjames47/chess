package chess;

import java.util.Collection;

public interface PieceMove {
    Collection<ChessMove> myPieceMoves(ChessBoard board, ChessPosition myPosition);

}