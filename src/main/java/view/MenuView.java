package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class MenuView extends View {
    private Image titleImage;
    private String TITLE_IMAGE_PATH = "src/main/resources/MenuTitle1.png";
    private JLabel settingsLabel;
    private JLabel startLabel;

    public MenuView() {
        super();
        // Load the title image
        try {
            titleImage = ImageIO.read(new File(TITLE_IMAGE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setLayout(null);
        //================================ LABELS ==================================
        // Settings label:_____________________
        settingsLabel = createLabel("Settings", 5, 5);
        settingsLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Settings clicked");
                //TODO: Open settings
            }

            // Change the color of the label when hovered
            @Override
            public void mouseEntered(MouseEvent e) {
                settingsLabel.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                settingsLabel.setForeground(new Color(255, 181, 255));
            }
        });
        add(settingsLabel);

        // Start label:________________________
        startLabel = createLabel("Start Game", 420, 350);
        startLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Start clicked");
                //TODO: Start the game
            }

            // Change the color of the label when hovered
            @Override
            public void mouseEntered(MouseEvent e) {
                startLabel.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startLabel.setForeground(new Color(255, 181, 255));
            }
        });
        add(startLabel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //================================ BACKGROUND ================================
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }

        //================================== TITLE ==================================
        if (titleImage != null) {
            int scaledWidth = titleImage.getWidth(this) * 2; // Scale width by 2
            int scaledHeight = titleImage.getHeight(this) * 2; // Scale height by 2
            g.drawImage(titleImage, getWidth() / 2 - scaledWidth / 2, 250, scaledWidth, scaledHeight, this);
        }

        //TODO:
        // Draw the buttons
        // Draw the cursor
        // Draw the credits
        // Draw the version
        // Draw the help
    }

    /**
     * Creates a JLabel with the specified text, x, and y position.
     *
     * @param text the text to be displayed on the label
     * @param x the x-coordinate of the label's position
     * @param y the y-coordinate of the label's position
     * @return the created JLabel
     */
    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setForeground(new Color(255, 181, 255));
        label.setFont(new Font("Arial", Font.PLAIN, 24));
        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int width = metrics.stringWidth(text);
        int height = metrics.getHeight();
        label.setBounds(x, y, width, height);
        return label;
    }

}
