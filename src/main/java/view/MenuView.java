package view;

import controller.GameController;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import model.Board;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MenuView extends View {
    private Image titleImage;
    private String TITLE_IMAGE_PATH = "src/main/resources/MenuTitle1.png";
    private String LABEL_HOVER_SOUND_PATH = "src/main/resources/HoverSound.wav";
    private String LABEL_CLICK_SOUND_PATH = "src/main/resources/ClickSound.mp3";
    private JLabel settingsLabel;
    private JLabel startLabel;
    private int width = 1024;
    private int height = 768;
    private int widthByTwo = width / 2;
    private int heightByTwo = height / 2;


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
        settingsLabel = createLabel("Settings", widthByTwo - 80, heightByTwo + 60);
        settingsLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                playSound(LABEL_CLICK_SOUND_PATH);
                //TODO: Open settings
            }

            // Change the color of the label when hovered
            @Override
            public void mouseEntered(MouseEvent e) {
                settingsLabel.setForeground(new Color(255, 181, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                settingsLabel.setForeground(Color.WHITE);
            }
        });
        add(settingsLabel);

        // Start label:________________________
        startLabel = createLabel("Start Game", widthByTwo - 110, heightByTwo);
        startLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                playSound(LABEL_CLICK_SOUND_PATH);
                //TODO: Start the game
                View gameView = new GameView();
                GameController gameController = new GameController(new Board(), gameView);
                gameController.start();
            }

            // Change the color of the label when hovered
            @Override
            public void mouseEntered(MouseEvent e) {
                startLabel.setForeground(new Color(255, 181, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startLabel.setForeground(Color.WHITE);
            }
        });
        add(startLabel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        drawBackground(g);
        drawTitle(g);

        //TODO:
        // Draw the buttons
        // Draw the cursor
        // Draw the credits
        // Draw the version
        // Draw the help
    }

    /**
     * Draws the background image to the screen.
     *
     * @param g the graphics object to draw with
     */
    private void drawBackground(Graphics g) {
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    /**
     * Draws the title image at the center of the screen.
     *
     * @param g the graphics object to draw with
     */
    private void drawTitle(Graphics g) {
        if (titleImage != null) {
            int scaledWidth = titleImage.getWidth(this);
            int scaledHeight = titleImage.getHeight(this);
            g.drawImage(titleImage, getWidth() / 2 - scaledWidth / 2, 300, scaledWidth, scaledHeight, this);
        }
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
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.PLAIN, 40));
        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int width = metrics.stringWidth(text);
        int height = metrics.getHeight();
        label.setBounds(x, y, width, height);
        return label;
    }

    /**
     * Plays a sound from the specified file path.
     *
     * @param path the path to the sound file
     */
    private boolean isPlaying = false;

    private void playSound(String path) {
        if (isPlaying) return;
        isPlaying = true;

        new Thread(() -> {
            try {
                FileInputStream fileInputStream = new FileInputStream(path);
                AdvancedPlayer player = new AdvancedPlayer(fileInputStream);
                player.play();
            } catch (FileNotFoundException e) {
                System.err.println("Sound file not found: " + path);
            } catch (JavaLayerException e) {
                System.err.println("Error playing sound: " + e.getMessage());
            } finally {
                isPlaying = false;
            }
        }).start();
    }
}