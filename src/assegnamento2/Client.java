package assegnamento2;

import java.util.ArrayList;
import java.util.Random;


/**
 * The {@code Client} class defines a person that: <p>
 * - Can buy wines. <p>
 * - Can order wine if it is not available in the store. <p>
 * Each client is defined by an Id.
 */
public class Client extends Person {

	private int id;	
	
	/**
	 * Class constructor. <p>
	 * Invokes the parent {@code Person}'s constructor. 
 	 * @see Person 
 	 
 	 * The id, if not specified, is generated random.
	 * @param name of the client.
	 * @param surname of the client.
	 * @param email of the client.
	 * @param password of the client.
	 */
	public Client(String name, String surname, String email, String password) {
		super(name, surname, email, password);
		Random r = new Random();
		id = r.nextInt();
	}
	
	/**
	 * Class constructor. <p>
	 * Invokes the parent {@code Person}'s constructor. 
 	 * @see Person 
 	 
 	 * @param id of the client.
	 * @param name of the client.
	 * @param surname of the client.
	 * @param email of the client.
	 * @param password of the client.
	 */
	public Client(int id, String name, String surname, String email, String password) {
		super(name, surname, email, password);
		this.id = id;
	}
	
	/**
	 * Getter for the client's Id.
	 * @return the client's Id.
	 */
	public int getID()
	{
		return id;
	}
	
	/**
	 * Setter for the client's Id.
	 * @param the client's Id.
	 */
	public void setID(int id)
	{
		this.id = id;
	}
	
	
	
	
}
