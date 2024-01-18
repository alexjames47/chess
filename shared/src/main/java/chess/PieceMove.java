package chess;

import java.util.Collection;

public interface PieceMove {
    Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition);

}