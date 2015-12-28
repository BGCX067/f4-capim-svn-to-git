/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package capimClient;

/**
 *
 * @author helinho
 */
public class Message {
    public int TYPE_MESSAGE;
    String DESTINATION;
    String MESSAGE;

    public Message(int type, String dest, String message){
        TYPE_MESSAGE = type;
        DESTINATION = dest;
        MESSAGE = message;
    }

    public Message(int type, String dest){
        TYPE_MESSAGE = type;
        DESTINATION = dest;
    }

}
