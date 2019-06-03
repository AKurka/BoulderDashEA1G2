package contract.view;

import java.awt.event.KeyEvent;

/**
 * <h1>The interface IEventPerformer</h1>
 *
 * @author Groupe2
 */

public interface IEventPerformer {

    /**
     * method use for transform and send the command set by the player
     * @param keyEvent
     *      key code of the command
     * @throws Exception
     * 		key code exception
     */
    void eventPerformer(KeyEvent keyEvent) throws Exception;
}
