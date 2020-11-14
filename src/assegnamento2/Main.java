package assegnamento2;


/*
TODO: 
print in giro
commenta LoggableUser

*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Store store = new Store();
		
		store.login("l.neri@gmail.com", "1234");
		store.displayWines();
		store.buy(100002, 20, false);
		store.displayWines();
		store.login("g.bianchi@gmail.com", "3434");
		store.buy(100000, 10, false);
		store.displayWines();
		store.login("m.rossi@gmail.com", "1212");
		//requesting to be notified
		store.buy(100000, 15, true);
		store.displayWines();
		store.login("l.mazza@gmail.com", "1111");
		store.restockWine(100000, 15);
		store.displayWines();
		store.login("m.rossi@gmail.com", "1212");

	}

}
