package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public abstract class View extends JPanel {
    private Timer timer;
    Image backgroundImage;
    String BACKGROUND_IMAGE_PATH = "src/main/resources/MenuBackground.jpg";

    public View() {
        // Initialize the timer to update at 60fps (1000ms / 60 = ~16ms)
        timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });
        timer.start();
        // Load the background image
        try {
            backgroundImage = ImageIO.read(new File(BACKGROUND_IMAGE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        // Redraw the view
        repaint();
    }
}