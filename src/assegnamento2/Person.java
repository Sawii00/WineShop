package assegnamento2;

import java.util.ArrayList;

/**
 * The {@code Person} class defines a generic person who attends the club. <p>
 * This class will be extended by the Member Class and Admin Class to distinguish 
 * between different roles. <p>
 * The {@code Person} class defines methods to get person's name, surname, email and passwords
 * and to set them.
 */

public class Person 
{
	/**
	 * Class constructor.
	 * 
	 * @param name name of the person.
	 * @param surname surname of the  person.
	 * @param email email of the  person.
	 * @param password password of the  person.
	 */

	public Person(String name, String surname, String email, String password)
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
	protected ArrayList<String> messages=new ArrayList<String>();
	
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
	 * @param name
	 */
	protected void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Getter for the person's surname.
	 * @return the person's surname.
	 */
	public String getSurname() 
	{
		return surname;
	}
	
	/**
	 * Setter for the person's surname.
	 * @param surname
	 */

	protected void setSurname(String surname) 
	{
		this.surname = surname;
	}

	/**
	 * Getter for the person's email.
	 * @return the person's email.
	 */
	public String getEmail() 
	{
		return email;
	}
	
	/**
	 * Getter for the person's password.
	 * @return the person's password.
	 */

	public String getPassword()
	{
		return password;
	}
	
	/**
	 * Setter for the person's email.
	 * @param email.
	 */
	protected void setEmail(String email)
	{
		this.email = email;
	}
	
	/**
	 * Setter for the person's password.
	 * @param password.
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
	
	/**
	 * Prints to the standard output the messages' list. 
	 */
	
	public void displayMessage() 
	{
		for (String m: messages) {
			System.out.println(m);
		}
	}
	
}