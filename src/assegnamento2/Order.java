package assegnamento2;

public class Order {
	
	private Client client;
	private Wine wine;
	
	public Order(Client c, Wine w)
	{
		client = c;
		wine = w;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Wine getWine() {
		return wine;
	}
	public void setWine(Wine wine) {
		this.wine = wine;
	}
	
	
}
