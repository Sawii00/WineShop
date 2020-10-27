package assegnamento2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Store {
	private ArrayList<Wine> wineList=new ArrayList<Wine>();
	private ArrayList<Order> orderList=new ArrayList<Order>();
	private ArrayList<Client> clientList=new ArrayList<Client>();
	private ArrayList<Seller> sellerList=new ArrayList<Seller>();
	private Map<Client,Wine> notifRequest=new HashMap<Client,Wine>();
	
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
	
	
	
	public void registerUser(Client c)
	{
		if(!contains(clientList,c))
			clientList.add(c);
	}
	
	public void registerSeller(Seller s)
	{
		if(!contains(sellerList,s))
			sellerList.add(s);
	}
	
	public void addWine(Wine w)
	{
		if(!contains(wineList, w))
			wineList.add(w);
		else
		{
			Wine cur = get(wineList, w);
			cur.setNumber(w.getNumber() + cur.getNumber());
		}
	}
	
	public void restockWine(Wine w, int extra_n)
	{
		if(contains(wineList, w))
			get(wineList, w).setNumber(w.getNumber() + extra_n);
		else
			wineList.add(w);
			
	}
	
	public boolean loginUser(String email, String password)
	{
		for(Client c: clientList)
		{
			if(c.getEmail() == email && c.getPassword() == password)
				return true;
		}
		return false;
	}
	
	public boolean loginSeller(String email, String password)
	{
		for(Seller c: sellerList)
		{
			if(c.getEmail() == email && c.getPassword() == password)
				return true;
		}
		return false;
	}
	
}
