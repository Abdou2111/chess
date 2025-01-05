package view;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class View extends JPanel {
    private Timer timer;
    Image backgroundImage;
    String BACKGROUND_IMAGE_PATH = "src/main/resources/MenuBackground.jpg";
    private String MUSIC_PATH = "src/main/resources/BackgroundMusic.mp3";

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

        // Play background music
        playMusic(MUSIC_PATH);
    }

    public void update() {
        // Redraw the view
        repaint();
    }

    /**
     * Plays the music at the specified path.
     *
     * @param path the path to the music file
     */
    private void playMusic(String path) {
        new Thread(() -> {
            try {
                FileInputStream fileInputStream = new FileInputStream(path);
                Player player = new Player(fileInputStream);
                player.play();
            } catch (FileNotFoundException | JavaLayerException e) {
                e.printStackTrace();
            }
        }).start();
    }
}