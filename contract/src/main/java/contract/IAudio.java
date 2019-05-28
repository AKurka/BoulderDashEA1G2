package contract;

import java.io.File;

public interface IAudio {
    public void playSound(File Sound, float gain);

    public void stopSound();
}
