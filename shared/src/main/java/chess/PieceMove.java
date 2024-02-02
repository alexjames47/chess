package chess;

import java.util.Collection;
import java.util.HashSet;

public interface PieceMove {
    Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition);





}