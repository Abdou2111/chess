package model;

public class Queen extends Piece {
    public Queen(boolean white, int x, int y) {
        super(PieceType.QUEEN, white, x, y);
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        // Queen can move in straight lines
        if (x == getX() && y == getY()) {
            return false;
        }
        // Queen can move diagonally
        if (x == getX() || y == getY()) {
            return true;
        }

        return Math.abs(x - getX()) == Math.abs(y - getY());
    }
}
