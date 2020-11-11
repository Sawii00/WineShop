package assegnamento2;


/**
 * The {@code Person} class defines a generic person who attends the club. <p>
 * This class will be extended by the Seller Class and Client Class to distinguish 
 * between different roles. <p>
 * The {@code Person} class defines methods to get person's name, surname, email and passwords
 * and to set them. <p>
 * There is also a list of messages that notifies the seller if there are some wines that
 * need to be restocked or the client if the wine that he ordered is available.
 */

public abstract class LoggableUser
{
	/**
	 * Class constructor.
	 * 
	 * @param name name of the person.
	 * @param surname surname of the  person.
	 * @param email email of the  person.
	 * @param password password of the  person.
	 */

	public LoggableUser(String name, String surname, String email, String password)
	{
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}
	
	protected String name;
	protected String surname;
	protected String email;
	protected String password;
	 
	
	/**
	 * Getter for the person's name.
	 * @return the person's name.
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * Setter for the person's name.
	 * @param name of the person.
	 */
	protected void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Getter for the person's surname.
	 * @return surname of the person.
	 */
	public String getSurname() 
	{
		return surname;
	}
	
	/**
	 * Setter for the person's surname.
	 * @param surname of the person.
	 */

	protected void setSurname(String surname) 
	{
		this.surname = surname;
	}

	/**
	 * Getter for the person's email.
	 * @return email of the person.
	 */
	public String getEmail() 
	{
		return email;
	}
	
	/**
	 * Getter for the person's password.
	 * @return password of the person.
	 */

	public String getPassword()
	{
		return password;
	}
	
	/**
	 * Setter for the person's email.
	 * @param email of the person.
	 */
	protected void setEmail(String email)
	{
		this.email = email;
	}
	
	/**
	 * Setter for the person's password.
	 * @param passowrd of the person.
	 */
	
	protected void setPassword(String password)
	{
		this.password = password;
	}
	
	/**
	 * Gives a textual representation of the person.
	 * @return the person's name, his surname and his email.
	 */
	
	public String toString()
	{
		return this.name+" "+this.surname+", "+this.email;
	}
	

	
}
	