package assegnamento2;


/**
 * The {@code Observer} interface is used to implement the Observer Design Pattern. <p>
 * {@code Client} and {@code Seller} implement the Interface to enable the receipt of notifications.
 * */
public interface Observer {

	
	/**
	 * Prints to the standard output the messages' list. 
	 */
	public void displayMessages();
	
	/**
	 * Clears all messages.
	 */
	public void deleteMessages();
	
	/**
	 * Adds a new message to the list.
	 * @param m the message.
	 */
	public void newMessage(String m);
	
	
}
