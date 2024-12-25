package model;

public class Pawn extends Piece {
    public Pawn(boolean white, int x, int y) {
        super(PieceType.PAWN, white, x, y);
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        return x == getX() && y == getY() + 1;
    }
}
