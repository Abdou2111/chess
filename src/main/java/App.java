import controller.GameController;
import model.Board;
import view.View;

public class App {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        // Create the model
        Board model = new Board();

        // Create the view
        View view = new View();

        // Create the controller
        GameController controller = new GameController(model, view);

        // Start the game
        controller.start();
    }
}
