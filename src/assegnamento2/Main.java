package assegnamento2;

/**
 * The {@code Main} class implements the simulation for the WineShop.
 * */
public class Main {

	public static void main(String[] args) {

		Store store = new Store();
		
		//customer login
		store.login("l.neri@gmail.com", "1234");
		//show list of all wines
		store.displayWines();
		//buys 20 bottles of wine with id 100002
		store.buy(100002, 20, false);
		//20 less bottles are shown in the database
		store.displayWines();
		//another customer logs in 
		store.login("g.bianchi@gmail.com", "3434");
		//buys all the bottles of wine 100000
		store.buy(100000, 10, false);
		//displays only the wine with id 100000
		store.displayWines("100000", SearchType.ID);
		//another customer logs in
		store.login("m.rossi@gmail.com", "1212");
		//he tries to buy the wine 100000 and requests to be notified in case not enough bottles are available
		store.buy(100000, 15, true);
		//the sellers logs in and should see the notification that a wine has run out of bottles
		store.login("l.mazza@gmail.com", "1111");
		//the seller re-stocks the wine 100000
		store.restockWine(100000, 15);
		store.displayWines("100000", SearchType.ID);

		//finally when the user asking to be notifies logs in again, he receives the message that the wine is available once more
		store.login("m.rossi@gmail.com", "1212");
		//he can then buy the bottles
		store.buy(100000, 15, false);

	}

}
