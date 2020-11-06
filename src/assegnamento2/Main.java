package assegnamento2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Store store = new Store();
		
		store.loginClient("pippo@gmail", "1234");
		store.displayWines();
		store.buy(100002, 20, false);
		store.displayWines();
		store.loginClient("bianchi@gmail", "3434");
		store.buy(100000, 10, false);
		store.displayWines();
		store.loginClient("rossi@gmail", "1212");
		store.displayWines();
		store.buy(100000, 15, true);
		store.displayWines();
		store.loginSeller("pindozz@gmail", "1111");
		store.restockWine(100000, 15);
		store.displayWines();
		store.loginClient("rossi@gmail", "1212");

	}

}
