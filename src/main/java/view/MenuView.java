package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MenuView extends View {
    private Image titleImage;
    private String TITLE_IMAGE_PATH = "src/main/resources/MenuTitle1.png";

    public MenuView() {
        super();
        // Load the title image
        try {
            titleImage = ImageIO.read(new File(TITLE_IMAGE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        //================================ BACKGROUND ================================
        if (backgroundImage != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            float opacity = 0.075f; // Set the desired opacity (0.0f to 1.0f)
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
            g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            g2d.dispose();
        }

        //================================== TITLE ==================================
        if (titleImage != null) {
            int scaledWidth = titleImage.getWidth(this) * 2; // Scale width by 2
            int scaledHeight = titleImage.getHeight(this) * 2; // Scale height by 2
            g.drawImage(titleImage, getWidth() / 2 - scaledWidth / 2, 200, scaledWidth, scaledHeight, this);
        }

        //================================== BUTTONS ==================================
        g.setFont(new Font("Arial", Font.PLAIN, 24));
        g.setColor(Color.WHITE);
        g.drawString("Start Game", getWidth() / 2 - 75, 350);
        g.drawString("Options", getWidth() / 2 - 50, 400);
        g.drawString("Exit", getWidth() / 2 - 25, 450);
        //TODO:
        // Draw the title
        // Draw the buttons
        // Draw the cursor
        // Draw the background
        // Draw the logo
        // Draw the credits
        // Draw the version
        // Draw the options
        // Draw the help
        // Draw the exit


    }

}
