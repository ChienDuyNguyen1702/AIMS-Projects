package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	private List<Media> itemsOrdered = new ArrayList<Media>();
	
	public void addMedia(Media item) {
		if (itemsOrdered.contains(item) == true) {
			System.out.println("The item has been already ");
		}else {
			itemsOrdered.add(item);
			System.out.println("The item has been added");
		}
	}
	
	public void removeMedia (Media item) {
		if (itemsOrdered.size() == 0) {
			System.out.println("Don't have item in list");
		}else if(itemsOrdered.contains(item) == false){
			System.out.println("The item hasn't been in list");
		}else {
			itemsOrdered.remove(item);
			System.out.println("The item has been deleted");
		}
	}
	
	public void removeAllMedia() {
		itemsOrdered.removeAll(itemsOrdered);
	}
	
	public float totalCost() {
		float totalCost = 0;
		for (Media item : itemsOrdered) {
			totalCost += item.getCost();
		}
		return totalCost;
	}
	public void viewCart() {
		for (Media media : itemsOrdered) {
			System.out.println(media.toString());;
		}
	}
	
	public List<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void getNumberDVD() {
		int i = 0;
		for (Media media : itemsOrdered) {
			if (media instanceof DigitalVideoDisc) {
				i++;
			}
		}
		System.out.println("The number of DVDs in the current cart: " + i + " (DVDs)");
		
	}
	
}
