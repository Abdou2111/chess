package model;

public class Bishop extends Piece {
    public Bishop(boolean white, int x, int y) {
        super(PieceType.BISHOP, white, x, y);
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (x == getX() || y == getY()) {
            // Bishop can only move diagonally
            return false;
        }
        // Check if there are any pieces in the way
        return Math.abs(x - getX()) == Math.abs(y - getY());
    }
}
