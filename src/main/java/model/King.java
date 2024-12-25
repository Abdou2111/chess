package model;

public class King extends Piece {
    public King(boolean white, int x, int y) {
        super(PieceType.KING, white, x, y);
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        return (x == getX() + 1 && y == getY()) ||     // Move right
               (x == getX() - 1 && y == getY()) ||     // Move left
               (x == getX() && y == getY() + 1) ||     // Move up
               (x == getX() && y == getY() - 1) ||     // Move down
               (x == getX() + 1 && y == getY() + 1) || // Move diagonally right up
               (x == getX() + 1 && y == getY() - 1) || // Move diagonally right down
               (x == getX() - 1 && y == getY() + 1) || // Move diagonally left up
               (x == getX() - 1 && y == getY() - 1);   // Move diagonally left down
    }
}
