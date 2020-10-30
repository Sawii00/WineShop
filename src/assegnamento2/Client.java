package assegnamento2;

import java.util.ArrayList;
import java.util.Random;

public class Client extends Person {

	private int id;
	
	private ArrayList<Order> orders=new ArrayList<Order>();
	

	public Client(String name, String surname, String email, String password) {
		super(name, surname, email, password);
		// TODO Auto-generated constructor stub
		Random r = new Random();
		id = r.nextInt();
	}
	
	public int getID()
	{
		return id;
	}
	
	public void addOrder(Order o)
	{
		orders.add(o);
	}
	
	
	
}
