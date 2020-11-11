package assegnamento2;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
* The class {@code Store} manages the Wine Shop through methods that work on the inner data structures. <p>
* It contains lists of wines, clients, sellers and orders. <p>
* {@code notifRequest} holds the requests of restock notifications made by the users. <p>
* {@code currSeller} and {@code currClient} hold the currently logged in user (Client and Sellers cannot be simultaneously logged in). <p>
* NOTE: this implementation does not allow for multiple users logged in simultaneously. Modifications are required in case multiple users have to be served in parallel.
*/

enum SearchType
{
	NAME, YEAR;
};


public class Store {
	
	private ArrayList<Wine> wineList=new ArrayList<Wine>();
	private ArrayList<Order> orderList=new ArrayList<Order>();
	
	
	private ArrayList<LoggableUser> userList = new ArrayList<LoggableUser>();
	
	/**
	 * Map of notification requests: <p>
	 * - Wine ID <p>
	 * - Client ID <p>
	 * - Amount of bottles
	 * */
	private Map<Integer, Entry <Integer,Integer>> notifRequest=new HashMap<Integer,Entry<Integer,Integer>>();
	
	private Client currClient = null;
	private Seller currSeller = null;
	
	/**
	* Class Constructor. <p>
	* It sets up an initial list of {@code Wines} available in the Store, some registered {@code Clients}, and one {@code Seller}. <p>
	*/
	public Store()
	{
		userList.add(new Client("Pippo", "Baudo", "pippo@gmail", "1234"));
		userList.add(new Client("Mario", "Rossi", "rossi@gmail", "1212"));
		userList.add(new Client("Giuseppe", "Bianchi", "bianchi@gmail", "3434"));
		
		userList.add(new Seller("Ale", "Pindozzi", "pindozz@gmail", "1111"));
		
		wineList.add(new Wine(100000, "Cabernet", "Cantina Bianchi", 1980, "Buono", "Uva", 10));
		wineList.add(new Wine(100001, "Cabernet2", "Cantina Rossi", 2011, "Buono", "Uva", 5));
		wineList.add(new Wine(100002,"Cabernet3", "Cantina Verdi", 3090, "Buono", "Uva", 100));
		wineList.add(new Wine(100003, "Cabernet4", "Cantina Violi", 1000, "Buono", "Uva", 1));
		wineList.add(new Wine(100004, "Cabernet5", "Cantina Gialli", 30, "Buono", "Uva", 0));
	}
	

	/**
	* It logs out the currently logged-in user by setting to {@code null} {@code currClient} and {@code currSeller}.
	*/
	private void logout()
	{
		currClient = null;
		currSeller = null;
	}
	
	/**
	* Generic method that returns whether an object is included in a list based on the string representation. <p>
	* It allows to check if a list contains an object without having to match the object's memory address (it only confronts inner data).
	*
	* @param list the list in which to search the object.
	* @param obj the object to find in the list.
	*
	* @return True if the object is found, False otherwise.
	*/
	private <T> boolean contains(ArrayList<T> list, T obj)
	{
		for(T t: list)
		{
			if(obj.toString().equals(t.toString()))
			{
				return true;
			}
		}
		return false;
	}
	
	
	
	private boolean alreadyRegistered(LoggableUser usr)
	{
		
		for(LoggableUser u: userList)
		{
			if(u.toString() == usr.toString())
				return true;
		}
		return false;
	}
	
	
	/**
	* Generic method that returns the object reference contained in the specified list of the specified object. <p>
	* It allows to retrieve an object without having to match the object's memory address by confronting the inner data. <p>
	* Employs the {@code contains} method to check if a suitable match is found. <p>
	* If no matching object is found, it returns {@code null}.
	*
	* @param list the list in which to search the object.
	* @param obj the object to find in the list.
	*
	* @return the object if found, or null.
	*/
	private <T> T get(ArrayList<T> list, T obj)
	{
		for(T t: list)
		{
			if(obj.toString().equals(t.toString()))
			{
				return t;
			}
		}
		return null;
	}
	
	/**
	* It retrieves the Wine that matches the specified id.
	*
	* @param wineId the id of the wine to be retrieved.
	*
	* @return the wine if found, null otherwise.
	*/
	private Wine getWineByID(int id)
	{
		for(Wine w: wineList)
		{
			if(w.getID() == id)
				return w;
		}
		return null;
	}
	
	/**
	* It retrieves the Client that matches the specified id. <p>
	*
	* @param clientId the id of the client to be retrieved.
	*
	* @return the client if found, null otherwise.
	*/
	private Client getClientByID(int id)
	{
		for(LoggableUser w: userList)
		{
			if(w instanceof Client && ((Client)w).getID() == id)
				return (Client)w;
		}
		return null;
	}
	

	/**
	* It allows the registration of a new {@code LoggableUser} to the Store. <p>
	* @param usr the client or seller to be registered.
	*/
	
	public void register(LoggableUser usr)
	{
		if(!alreadyRegistered(usr))
		{
			if(usr instanceof Client)
				((Client)usr).setID(userList.size());
			userList.add(usr);
		}
	}

	/**
	 * Allows to add a wine to the wineList. <p>
	 * At first this method check if there is a seller logged in. <p>
	 * If a seller is logged in it check if the wine you want to add is in wineList. <p>
	 * If the wine passed as parameter is not in the list it is added to the wineList e 
	 * added a wineId. <p>
	 * If it is already present in the list, the number of bottles is updated.
	 * @param w the wine you want to add to the wineList.
	 */
	public void addWine(Wine w)
	{
		if(currSeller == null)
		{
			System.out.println("No Seller is logged in.");
			return;
		}
		
		if(!contains(wineList, w))
		{
			w.setID(100000+wineList.size());
			wineList.add(w);
			
		}
		else
		{
			Wine cur = get(wineList, w);
			cur.setNumber(w.getNumber() + cur.getNumber());
		}
	}
	
	/**
	* Restocks {@code extraN} numbers of bottles of the specified wine. <p>
	* Precondition: a seller is logged in.
	* @param wineId id of the wine to be restocked.
	* @param extraN number of bottles to be added.
	*/
	public void restockWine(int wineId, int extraN)
	{
		if(currSeller == null)
		{
			System.out.println("No Seller is logged in.");
			return;
		}
		Wine w=getWineByID(wineId);
		if(w!=null)
		{
			w.setNumber(w.getNumber() + extraN);
			for (Integer i: notifRequest.keySet())
			{
				if (i==wineId) 
				{
					Entry e = notifRequest.get(i);
					if((Integer)e.getValue() <= extraN)
					{
						getClientByID((Integer)e.getKey()).newMessage("Wine: "+wineId+" is available.");
					}
				}
			}
		}
	}
	
	/**
	* It allows the login of a {@code LoggableUser} to the Store. <p>
	* @param email the user's email.
	* @param password the user's password.
	*/
	public boolean login(String email, String password)
	{
		logout();
		for(LoggableUser usr: userList)
		{
			if(usr.getEmail() == email && usr.getPassword() == password)
			{
				if(usr instanceof Client)
					currClient = (Client)usr;
				else
					currSeller = (Seller)usr;
				((Observer)usr).displayMessages();
				((Observer)usr).deleteMessages();
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Prints to the standard output the wineList. <p>
	 * First it is checked if there are clients or sellers logged in. <p>
	 * If there are any, it print to the std output the list, otherwise specifies that no
	 * person is logged in.
	 */
	public void displayWines()
	{
		if(currClient == null && currSeller == null)
		{
			System.out.println("No user is logged in.");
			return;
		}
		
		for(Wine w: wineList)
		{
			System.out.println(w.toString());
		}
		System.out.println();
	}
	
	/**
	* Displays only the wines that match the specified query. <p>
	* It employs the search method and therefore allows to show all the wines that match a specified name or year. <p>
	* Precondition: a user is logged in.
	*
	* @param searchText text to be searched
	* @param searchType type of search (YEAR, NAME)
	*/
	public void displayWines(String text, SearchType type)
	{
		if(currClient == null && currSeller == null)
		{
			System.out.println("No user is logged in.");
			return;
		}
		
		for(Wine w: search(text, type))
		{
			System.out.println(w.toString());
		}
		System.out.println();

	}
	
	/**
	* Sells {@code amount} bottles of the wine specified by the {@code wineId} to the currently logged-in client. <p>
	*
	* @param wineId id of the wine to be bought
	* @param amount amount of bottles to be bought
	* @param requestIfNotAvailable express willingness to be notified in case of the absence of the needed amount
	*
	*
	*/
	private ArrayList<Wine> search(String search_text, SearchType type)
	{
		ArrayList<Wine> res = new ArrayList<Wine>();
		
		if(type == SearchType.NAME)
		{
			for(Wine w: wineList)
				if(w.getName() == search_text)
					res.add(w);
			
		}
		else if(type == SearchType.YEAR)
		{
			for(Wine w: wineList)
				if(w.getYear() == Integer.parseInt(search_text))
					res.add(w);
		}
		
		return res;
		
	}
	

	/**
	* Sells {@code amount} bottles of the wine specified by the {@code wineId} to the currently logged-in client. <p>
	*
	* Precondition: a client is logged in.
	*
	* @param wineId id of the wine to be bought
	* @param amount amount of bottles to be bought
	* @param requestIfNotAvailable express willingness to be notified in case of the absence of the needed amount
	*
	*
	*/
	public boolean buy(int wineId, int amount, boolean requestIfNotAvailable)
	{
		if(currClient == null)
		{
			System.out.println("No user is logged in.");
			return false;
		}
		
		Wine w = getWineByID(wineId);
		if(w != null)
		{
			if(w.getNumber() > amount)
			{
				w.setNumber(w.getNumber() - amount);
				orderList.add(new Order(currClient.getID(), new Wine(w.getName(), w.getProducer(), w.getYear(), w.getTechnicalNotes(), w.getGrapeType(), amount)));
				return true;
			}
			else if (w.getNumber()==amount)
			{
				for (LoggableUser s: userList)
				{
					if(s instanceof Seller)
						((Seller)s).newMessage("Wine: "+w.getID()+" needs to be restocked.");
				}
				
				w.setNumber(w.getNumber() - amount);
				orderList.add(new Order(currClient.getID(), new Wine(w.getName(), w.getProducer(), w.getYear(), w.getTechnicalNotes(), w.getGrapeType(), amount)));
				return true;			
			}
			else
			{
				if(requestIfNotAvailable)
				{
					requestWine(wineId, currClient.getID(), amount);
				}
				return false;
			}
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * A notify is sent to to the seller, so that he knows which wine needs to be restocked,
	 * and which client did the order.
	 * @param wineId the id of the wine that allows to uniquely identify it.
	 * @param clientId the id of the person that allows to uniquely identify him.
	 * @param amount the numbers of bottles requested. 
	 */
	private void requestWine(int wineId, int clientId, int amount)
	{
		if(currClient == null)return;

		notifRequest.put(wineId, new AbstractMap.SimpleEntry(clientId,amount));
	}
}
