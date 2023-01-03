package hust.soict.dsai.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.book.Book;
import hust.soict.dsai.aims.cd.CompactDisc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class TestMedia {
	public static void main(String[] args) {
		List<Media> mediae = new ArrayList<Media>();
		Media cd = new CompactDisc("Babaluga", "Detective", 3.5f);
		Media dvd = new DigitalVideoDisc("Gaoranger", "Action", 2.4f);
		Media book = new Book("Star war", "Action", 2.8f);
		
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);
		
		for (Media media : mediae) {
			System.out.println(media.toString());
		}
		
		System.out.println("Sing a song");
		
	}
}
