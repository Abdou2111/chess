package model;

public class Knight extends Piece {
    public Knight(boolean white, int x, int y) {
        super(PieceType.KNIGHT, white, x, y);
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        return (x == getX() + 2 && y == getY() + 1) ||
               (x == getX() + 2 && y == getY() - 1) ||
               (x == getX() - 2 && y == getY() + 1) ||
               (x == getX() - 2 && y == getY() - 1) ||
               (x == getX() + 1 && y == getY() + 2) ||
               (x == getX() + 1 && y == getY() - 2) ||
               (x == getX() - 1 && y == getY() + 2) ||
               (x == getX() - 1 && y == getY() - 2);
    }
}
