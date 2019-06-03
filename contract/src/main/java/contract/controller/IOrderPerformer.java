package contract.controller;

/**
 *  <h1>The interface of OrderPerformer</h1>
 *
 * @author Groupe2
 *
 */
public interface IOrderPerformer {

    /**
     * method use for understand what order is doing by the player
     * @param order
     * 			order take
     * @throws Exception
     * 			thread exception
     */
    void orderPerformer(Order order) throws Exception;

}
