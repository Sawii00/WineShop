package assegnamento2;

import java.util.ArrayList;

/**
 * The {@code Seller} class defines a person that: <p>
 * - Receives a notification if some bottles of a type of wine have run out. <p>
 * - Can restockes the bottles of not available wine. <p>
 *  Implements the {@code Observer} Interface.
 */

public class Seller extends LoggableUser implements Observer{
	
	
	protected ArrayList<String> messages=new ArrayList<String>();

	/**
	 * Class constructor. <p>
	 * Invokes the parent {@code Person}'s constructor. 
 	 * @see Person 
 	 
	 * @param name of the seller.
	 * @param surname of the seller.
	 * @param email of the seller.
	 * @param password of the seller.
	 */
	public Seller(String name, String surname, String email, String password) {
		super(name, surname, email, password);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * {@inheritDoc}
	 * */
	@Override
	public void displayMessages() 
	{
		for (String m: messages) {
			System.out.println(m);
		}
	}
	
	/**
	 * {@inheritDoc}
	 * */
	@Override
	public void deleteMessages()
	{
		messages.clear();
	}
	
	/**
	 * {@inheritDoc}
	 * */
	@Override
	public void newMessage(String m)
	{
		messages.add(m);
	}
	
	
}
