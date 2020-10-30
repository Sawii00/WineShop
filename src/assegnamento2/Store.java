package assegnamento2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

enum SearchType
{
	NAME, YEAR;
};


public class Store {
	private static ArrayList<Wine> wineList=new ArrayList<Wine>();
	private static ArrayList<Order> orderList=new ArrayList<Order>();
	private static ArrayList<Client> clientList=new ArrayList<Client>();
	private static ArrayList<Seller> sellerList=new ArrayList<Seller>();
	private static Map<Client,Wine> notifRequest=new HashMap<Client,Wine>();
	
	private static <T> boolean contains(ArrayList<T> list, T obj)
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
	
	private static <T> T get(ArrayList<T> list, T obj)
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
	
	private static Wine getWineByID(int id)
	{
		for(Wine w: wineList)
		{
			if(w.getID() == id)
				return w;
		}
		return null;
	}
	

	private static Client getClientByID(int id)
	{
		for(Client w: clientList)
		{
			if(w.getID() == id)
				return w;
		}
		return null;
	}
	
	
	
	public static void registerUser(Client c)
	{
		if(!contains(clientList,c))
			clientList.add(c);
	}
	
	public static void registerSeller(Seller s)
	{
		if(!contains(sellerList,s))
			sellerList.add(s);
	}
	
	public static void addWine(Wine w)
	{
		if(!contains(wineList, w))
			wineList.add(w);
		else
		{
			Wine cur = get(wineList, w);
			cur.setNumber(w.getNumber() + cur.getNumber());
		}
	}
	
	public static void restockWine(Wine w, int extra_n)
	{
		if(contains(wineList, w))
			get(wineList, w).setNumber(w.getNumber() + extra_n);
		else
			wineList.add(w);
			
	}
	
	public static boolean loginUser(String email, String password)
	{
		for(Client c: clientList)
		{
			if(c.getEmail() == email && c.getPassword() == password)
				return true;
		}
		return false;
	}
	
	public static boolean loginSeller(String email, String password)
	{
		for(Seller c: sellerList)
		{
			if(c.getEmail() == email && c.getPassword() == password)
				return true;
		}
		return false;
	}
	
	public static ArrayList<Wine> search(String search_text, SearchType type)
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
	
	
	public static boolean buy(int wine_id, int amount, int client_id)
	{
		Wine w = getWineByID(wine_id);
		if(w != null)
		{
			if(w.getNumber() >= amount)
			{
				w.setNumber(w.getNumber() - amount);
				orderList.add(new Order(getClientByID(client_id), new Wine(w.getName(), w.getProducer(), w.getYear(), w.getTechnicalNotes(), w.getGrapeType(), amount)));
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
	}
	
}
