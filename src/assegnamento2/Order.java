package assegnamento2;

/**
 * The {@code Order} class represents a purchase order. <p>
 * An order is defined by the client who buys the wine and the wine which is bought.
 */
public class Order {
	
	private int client;
	private Wine wine;
	
	/**
	 * Class constructor.
	 * @param c the client who buy the wine
	 * @param w the wine that is bought.
	 */
	public Order(int c, Wine w)
	{
		client = c;
		wine = w;
	}
	
	/**
	 * Getter for the client.
	 * @return the client who wants to order wine.
	 */
	public int getClient() {
		return client;
	}
	
	/**
	 * Setter for the client.
	 * @param client who wants to order wine.
	 */
	public void setClient(int client) {
		this.client = client;
	}
	
	/**
	 * Getter for the wine bought.
	 * @return wine the wine ordered.
	 */
	public Wine getWine() {
		return wine;
	}
	
	/**
	 * Setter for the wine bought.
	 * @param wine the wine ordered.
	 */
	public void setWine(Wine wine) {
		this.wine = wine;
	}
	
	
}
