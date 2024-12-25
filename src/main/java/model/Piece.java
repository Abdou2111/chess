package model;

public abstract class Piece {
    private PieceType pieceType;
    private boolean white;
    private int x, y;

    public Piece(PieceType pieceType, boolean white, int x, int y) {
        this.pieceType = pieceType;
        this.white = white;
    }

    public abstract boolean canMove(Board board, int x, int y);


    public PieceType getPieceType() {
        return pieceType;
    }

    public boolean isWhite() {
        return white;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
