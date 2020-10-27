package assegnamento2;

import java.util.ArrayList;

public class Client extends Person {

	public Client(String name, String surname, String email, String password) {
		super(name, surname, email, password);
		// TODO Auto-generated constructor stub
	}
	
	private ArrayList<Order> Orders=new ArrayList<Order>();
}
