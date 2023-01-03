package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Media;

public class Store {
	private List<Media> itemInStore = new ArrayList<Media>();
	
	public void addMedia(Media item) {
		if (itemInStore.contains(item) == true) {
			System.out.println("The item has been already ");
		}else {
			itemInStore.add(item);
			System.out.println("The item has been added");
		}
	}
	
	public void removeMedia (Media item) {
		if (itemInStore.size() == 0) {
			System.out.println("Don't have item in list");
		}else if(itemInStore.contains(item) == false){
			System.out.println("The item hasn't been in list");
		}else {
			itemInStore.remove(item);
			System.out.println("The item has been deleted");
		}
	}
	
	public void viewStore() {
		for (Media media : itemInStore) {
			System.out.println(media.toString());;
		}
	}

	public List<Media> getItemInStore() {
		return itemInStore;
	}
	
}
