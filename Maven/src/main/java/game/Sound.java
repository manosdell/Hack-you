package game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;

/**
 * Αναπαραγωγή ήχου και ηχητικών εφέ
 * TODO(Emmanouil Dellatolis) Προσθήκη Coin Sound Effect
 *
 * @author Team Hack-You
 */
public final class Sound {

    Clip clip;
    private final URL[] soundURL = new URL[5];

    /**
     * <p>Constructor for Sound.</p>
     */
    public Sound() {
        soundURL[0] = getClass().getResource("/sound/audio_thiseas.wav");
        soundURL[1] = getClass().getResource("/sound/sound_effect.wav");
        soundURL[2] = getClass().getResource("/sound/Coin_1.wav");
        //soundURL[3] = getClass().getResource("");
        //soundURL[4] = getClass().getResource("");
    }

    /**
     * <p>setFile.</p>
     *
     * @param i a int
     */
    public void setFile(int i) {

        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

    }

    /**
     * <p>play clip</p>
     */
    public void play() {
        clip.start();
    }

    /**
     * <p>loop clip</p>
     */
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * <p>stop clip</p>
     */
    public void stop() {
        clip.stop();
    }

}
