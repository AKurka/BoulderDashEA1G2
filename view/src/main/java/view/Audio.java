package view;

import contract.IAudio;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class Audio implements IAudio {
    private Clip clip;

    public void playSound(File Sound, float gain){
        try{
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(gain);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void stopSound(){
        clip.stop();
    }
}
