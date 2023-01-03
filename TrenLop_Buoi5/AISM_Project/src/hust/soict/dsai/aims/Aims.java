package hust.soict.dsai.aims;

import hust.soict.dsai.aims.book.Book;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.cd.CompactDisc;
import hust.soict.dsai.aims.cd.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	public static Cart cart = new Cart();
	public static Store store = new Store();
	public static void main(String[] args) {
		CompactDisc cd = new CompactDisc("Maybe", "Mimi", 3.1f);
		cd.addTrack(new Track("Element", 3));
		cd.addTrack(new Track("New human", 5));
		store.addMedia(cd);
		store.addMedia(new CompactDisc("Hugo", "Action", 3.5f));
		store.addMedia(new CompactDisc("Avatar", "Action", 2.4f));
		store.addMedia(new Book("Nothing", "Babe", 3.2f));
		store.addMedia(new CompactDisc("Starwar", "Action", "Babe", "Never", 3, 3.5f));;
		Options.RunApp();
	}
}

class Menu {
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("------------------------------");
		System.out.println("Please choose a number (0-1-2-3): ");
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("------------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("-------------------------------");
		System.out.println("Please choose a number (0-1-2-3-4): ");
	}
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}


}