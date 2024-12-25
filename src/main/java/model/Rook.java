package model;

public class Rook extends Piece{
    public Rook(boolean white, int x, int y) {
        super(PieceType.ROOK, white, x, y);
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        // Rook can only move in straight lines
        return x == getX() || y == getY();
    }
}
