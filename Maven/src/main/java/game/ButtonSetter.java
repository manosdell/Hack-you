package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Πρότυπο για την επεξεργασία buttons
 *
 * @author Team Hack-You
 * @version 1.0
 */
public final class ButtonSetter {

    private static final Sound se = new Sound();
    /**
     * Αν θα αναπαράγεται ήχος από το παιχνίδι ή όχι
     */
    private static boolean playSound = true;
    private static int counter = 0;
    private static ImageIcon icon;

    /**
     * <p>setButton.</p>
     *
     * @param button a {@link javax.swing.JButton} object
     * @param x      position x
     * @param y      position x
     * @param width  width
     * @param height height
     * @param font   a {@link java.awt.Font} object
     * @param object an {@link java.awt.event.ActionListener} object
     */
    public static void setButton(JButton button, int x, int y, int width, int height, Font font, ActionListener object) {
        button.setBounds(x, y, width, height);
        button.setFocusable(false);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setForeground(Color.black);
        button.setFont(font);
        button.addActionListener(object);
        setButtonIcon(button, width, height);
    }

    /**
     * <p> setButtonIcon.</p>
     *
     * @param button a {@link javax.swing.JButton} object
     * @param width  width
     * @param height height
     */
    private static void setButtonIcon(JButton button, int width, int height) {
        counter++;
        BufferedImage image;
        try {
            image = ImageIO.read(ButtonSetter.class.getResourceAsStream(
                    String.format("/buttons/wood%d.png", (counter % 2 == 1 ? 2 : 1))));
            image = FrameSetter.scaleImage(image, width, height);
            icon = new ImageIcon(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        button.setIcon(icon);
    }

    /**
     * <p>Getter for the field <code>playSound</code>.</p>
     *
     * @return a boolean
     */
    public static boolean getPlaySound() {
        return playSound;
    }

    /**
     * <p>Setter for the field <code>playSound</code>.</p>
     *
     * @param playSound a boolean
     */
    public static void setPlaySound(boolean playSound) {
        ButtonSetter.playSound = playSound;
    }

    /**
     * Αναπαραγωγή sound effect κλικ κουμπιού
     */
    public static void playSE() {
        if (!playSound)
            return;
        se.setFile(1);
        se.play();
    }
}
