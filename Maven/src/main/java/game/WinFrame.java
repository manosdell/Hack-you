package game;

import highscoreTest.HighScore;
import highscoreTest.HighScoreFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Παράθυρο που ανοίγει στην περίπτωση που ο παίκτης κέρδισε
 *
 * @author Team Hack-You
 */
public final class WinFrame implements ActionListener {

    private final JFrame frame;
    private final JLabel backgroundLabel = new JLabel();
    private final JButton playAgain = new JButton("play again");
    private final JButton seeHighScores = new JButton("check HighScore table");
    private final JButton back_to_menu = new JButton("back to Menu");
    private final JButton exit = new JButton("exit");
    private HighScoreFrame highScoreFrame;
    private final JLabel minLabel = new JLabel();
    private final JLabel thLabel = new JLabel();

    private final HighScore highScore;

    /**
     * <p>setSeeHighScoresStatus.</p>
     *
     * @param status a boolean
     */
    public void setSeeHighScoresStatus(boolean status) {
        seeHighScores.setEnabled(status);
    }

    /**
     * <p>Getter for the field <code>highScore</code>.</p>
     *
     * @return a {@link highscoreTest.HighScore} object
     */
    public HighScore getHighScore() {
        return highScore;
    }

    /**
     * <p>Constructor for WinFrame.</p>
     */
    public WinFrame() {
        frame = new JFrame();
        FrameSetter.setFrame(frame, "Victory", 800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Έλεγχος για το αν ο παίκτης έκανε νέο highscore
        highScore = new HighScore(Username.getUsername(), calculateScore());

        ButtonSetter.setButton(playAgain, 275, 300, 250, 50, new Font("Calibri", Font.ITALIC, 20), this);
        ButtonSetter.setButton(seeHighScores, 275, 400, 250, 50, new Font("Calibri", Font.ITALIC, 20), this);
        ButtonSetter.setButton(back_to_menu, 275, 500, 250, 50, new Font("Calibri", Font.ITALIC, 20), this);
        ButtonSetter.setButton(exit, 275, 600, 250, 50, new Font("Calibri", Font.ITALIC, 20), this);

        frame.add(playAgain);
        frame.add(seeHighScores);
        frame.add(back_to_menu);
        frame.add(exit);

        FrameSetter.scaleImgToLabel(minLabel, 350, 0, 120, 100, new ImageIcon("src/main/resources/minotaur/minotaurlose3.png"));
        frame.add(minLabel);
        FrameSetter.scaleImgToLabel(thLabel, 365, 100, 100, 70, new ImageIcon("src/main/resources/thiseas2/thiseasswind.png"));
        frame.add(thLabel);

        GraphicPane graphicPane = new GraphicPane("VICTORY!", 800, 100, new Color(23, 131, 59),new Font("Times new Roman", Font.BOLD,60));
        graphicPane.setBounds(0, 150, 800, 150);
        frame.add(graphicPane);

        FrameSetter.scaleBackground(backgroundLabel, 800, 800);
        frame.add(backgroundLabel);
    }

    //TODO(all) προσθήκη συνάρτησης υπολογισμού score

    /**
     * <p>calculateScore.</p>
     *
     * @return a int
     */
    public int calculateScore() {

        return 0;
    }

    /**
     * <p>check.</p>
     */
    public void check() {
        if (highScoreFrame == null)
            return;
        if (highScoreFrame.getIsOpen())
            highScoreFrame.closeFrame();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonSetter.playSE();
        if (e.getSource() == playAgain) {
            check();
            SwingUtilities.invokeLater(LabyrinthFrame::new);
            Quiz.indexes.clear();
        } else if (e.getSource() == seeHighScores) {
            highScoreFrame = new HighScoreFrame(this);
            seeHighScores.setEnabled(false);
            return;
        } else if (e.getSource() == back_to_menu) {
            check();
            SwingUtilities.invokeLater(Menu::new);
            Quiz.indexes.clear();
        } else {
            System.exit(1);
        }
        frame.dispose();
    }
}
