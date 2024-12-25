package model;

public class Board {
    private Piece[][] board;

    public Board() {
        board = new Piece[8][8];
    }

    public Piece getPiece(int x, int y) {
        return board[x][y];
    }

    public void setPiece(Piece piece, int x, int y) {
        board[x][y] = piece;
    }

    public void movePiece(int x1, int y1, int x2, int y2) {
        board[x2][y2] = board[x1][y1];
        board[x1][y1] = null;
    }
}
