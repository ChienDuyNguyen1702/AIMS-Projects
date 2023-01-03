package hust.soict.dsai.aims.book;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Media;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
			
	public void addAuthor(String authorName) {
		if (authors.contains(authorName) == true) {
			System.out.println("The author has been already ");
		}else {
			authors.add(authorName);
			System.out.println("The author has been added");
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.size() == 0) {
			System.out.println("Don't have author in list");
		}else if(authors.contains(authorName) == false){
			System.out.println("The author hasn't been in list");
		}else {
			authors.remove(authorName);
			System.out.println("The author has been deleted");
		}
	}		
		
		
//		public void printBookInfo() {
//			System.out.println("This is the book infor: ");
//			System.out.println("\t------------------------------------------------------");
//			System.out.print("\tTitle\t     |\tCategory\t|\tAuthors\n");
//			System.out.printf("\t%s    |\t%s\t\t|\t%s\n", title, category, authors[0]);
//			for (int i = 1; i < authors.length; i++) {
//				System.out.printf("\t\t     |\t\t        |\t%s\n", authors[i]);
//			}
//			System.out.println("\t------------------------------------------------------");
//		}
	public String toString() {
		return super.getTitle() + "\t\t" + super.getCatogary() + "\t\t" + super.getCost() + "\n";
	}
}
