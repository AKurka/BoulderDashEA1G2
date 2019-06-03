package model;

public interface Interaction {

    /**
     * method description for kill
     * @param element
     *      Element able to be kill
     */

    void kill(Element element);

    /**
     * method description for get
     * @param boulder
     *      the boulder element
     * @throws Exception
     *      getMap exception
     */
    void get(Boulder boulder) throws Exception;
}
