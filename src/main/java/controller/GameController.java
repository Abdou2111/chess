package controller;

import model.Board;
import view.View;


public class GameController {
    private Board model;
    private View view;

    public GameController(Board model, View view) {
        this.model = model;
        this.view = view;
    }

    public void onUserInput(int x1, int y1, int x2, int y2) {
        if (model.getPiece(x1, y1).canMove(model, x2, y2)) {
            model.movePiece(x1, y1, x2, y2);
            view.update();
        }
    }

    public void start() {
        view.update();
    }
}
