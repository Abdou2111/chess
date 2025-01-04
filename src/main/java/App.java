import controller.GameController;
import model.Board;
import view.MenuView;
import view.View;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {

    public static JFrame gameFrame;
    public static void main(String[] args) {
        init();
    }

    public static void init() {

        // Create the model
        Board model = new Board();

        // Create the view
        View view = new MenuView();

        // Create the controller
        GameController menuController = new GameController(model, view);

        gameFrame = frame(view);

        // Start the game
        menuController.start();
    }

    public static JFrame frame(View view) {
        JFrame frame = new JFrame("Chess");
        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(view);
        frame.setBackground(Color.BLACK);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setResizable(false);
        frame.setVisible(true);
        return frame;
    }
}
