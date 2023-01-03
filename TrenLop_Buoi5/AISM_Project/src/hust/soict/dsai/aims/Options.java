package hust.soict.dsai.aims;

import java.util.Collections;
import java.util.Scanner;

import hust.soict.dsai.aims.book.Book;
import hust.soict.dsai.aims.cd.CompactDisc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Options {
	
	static Scanner sr = new Scanner(System.in);
	public static void RunApp() {
		int choose;
		try {
			do {
				Menu.showMenu();
				choose = sr.nextInt();
				sr.nextLine();
				switch (choose) {
				case 1:
					ViewStore();
					break;
				case 2:
					UpdateStore();
					break;
				case 3:
					SeeCart();
					break;
				case 0:
					System.out.println("The application is close...");
					break;
				default:
					System.out.println("Your choose doesn't have!");
					System.out.println("Please choose again!");
					break;
				}
			} while(choose < 0 || choose > 3);
		} catch (Exception e) {
			System.out.println("Error");
			RunApp();
		}
	}
	
	public static void ViewStore() {
		int choose;
		try {
			do {
				Aims.store.viewStore();
				Menu.storeMenu();
				choose = sr.nextInt();
				sr.nextLine();
				switch (choose) {
				case 1:
					MediaDetail();
					break;
				case 2:
					AddMediaToCart();
					ViewStore();
					break;
				case 3: 
					PlayMediaStore();
					ViewStore();
					break;
				case 4:
					SeeCart();
					break;
				case 0:
					RunApp();
					break;
				default:
					System.out.println("Your choose doesn't have");
					break;
				}
			} while (choose < 0 || choose > 4);
		} catch (Exception e) {
			System.out.println("Error");
			ViewStore();
		}
		
	}
	
	public static void MediaDetail() {
		String title;
		int i = 0;
		Media mediax = null;
		int choose;
		try {
			System.out.println("Please enter the title of the media: ");
			title = sr.nextLine();
			for (Media media : Aims.store.getItemInStore()) {
				if (title.compareTo(media.getTitle()) == 0) {
					System.out.println("\n-------------------------------------------------------------------------------------------------------------");
					System.out.println(media.toString());
					i++;
					mediax = media;
					break;
				}
			}
			if (i == 0) {
				System.out.println("Don't have this media\n");
				ViewStore();
				return;
			}
			do {
				Menu.mediaDetailsMenu();
				choose = sr.nextInt();
				sr.nextLine();
				switch (choose) {
				case 1:
					AddToCart(mediax);
					ViewStore();
					break;
				case 2:
					Play(mediax);
					ViewStore();
					break;
				case 0:
					ViewStore();
					break;
				default:
					System.out.println("Your choose doesn't have");
					break;
				}
			} while (choose < 0 || choose > 4);
		} catch (Exception e) {
			System.out.println("Error");
			ViewStore();
		}	
	}
	
	
	public static void Play(Media media) {
		if (media instanceof Book) {
			System.out.println("Book can't play!!!\n");
			return;
		}
		if (media instanceof DigitalVideoDisc) {
			((DigitalVideoDisc) media).play();
		}
		if (media instanceof CompactDisc) {
			((CompactDisc) media).play();
		}
		return;
	}
	
	public static void AddToCart(Media media) {
		if (media == null) {
			System.out.println("Can't add media !!! Don't see media\n");
		}else Aims.cart.addMedia(media);
	}
	
	public static void AddMediaToCart() {
		String title;
		int i;
		try {
			do {
				Aims.store.viewStore();
				System.out.println("Please enter the title of the media: ");
				title = sr.nextLine();
				i = 0;
				for (Media media : Aims.store.getItemInStore()) {
					if(title.compareTo(media.getTitle()) == 0) {
						i++;
						Aims.cart.addMedia(media);
						if (media instanceof DigitalVideoDisc) Aims.cart.getNumberDVD();
						break;
					}
				}
				if (i == 0) {
					System.out.println("Can't find this media.");
				}
			} while (i == 0);
		} catch (Exception e) {
			System.out.println("Error!!!");
		}
		
	}
	
	public static void PlayMediaStore() {
		String title;
		int i = 0;
		try {
			do {
				System.out.println("Please enter the title of the media: ");
				title = sr.nextLine();
				for (Media media : Aims.store.getItemInStore()) {
					if(title.compareTo(media.getTitle()) == 0) {
						if (media instanceof CompactDisc) {
							((CompactDisc) media).play();
							return;
						}
						if (media instanceof DigitalVideoDisc) {
							((DigitalVideoDisc) media).play();
							return;
						}
						if (media instanceof Book) {
							System.out.println("Book can't play!!!\n");
							return;
						}
					}
				}
				if (i == 0) {
					System.out.println("Can't find this media.");
				}
			} while (i == 0);
		} catch (Exception e) {
			System.out.println("Error!!!");
		}
	}
	
	public static void PlayMediaCart() {
		String title;
		int i = 0;
		try {
			do {
				System.out.println("Please enter the title of the media: ");
				title = sr.nextLine();
				for (Media media : Aims.cart.getItemsOrdered()) {
					if(title.compareTo(media.getTitle()) == 0) {
						if (media instanceof CompactDisc) {
							((CompactDisc) media).play();
							return;
						}
						if (media instanceof DigitalVideoDisc) {
							((DigitalVideoDisc) media).play();
							return;
						}
						if (media instanceof Book) {
							System.out.println("Book can't play!!!\n");
							return;
						}
					}
				}
				if (i == 0) {
					System.out.println("Can't find this media.");
				}
			} while (i == 0);
		} catch (Exception e) {
			System.out.println("Error!!!");
		}
	}
	
	public static void UpdateStore() {
		int choose;
		try {
			do {
				System.out.println("Do you want to add a media to or remove a media from the store ?");
				System.out.println("1. Add new media to store.");
				System.out.println("2. Remove media from store.");
				System.out.println("0. Back");
				System.out.printf("Your choose is (0-1-2): ");
				choose = sr.nextInt();
				sr.nextLine();
				switch (choose) {
				case 1:
					AddMediaToStore();
					UpdateStore();
					break;
				case 2:
					RemoveMediaStore();
					UpdateStore();
					break;
				case 0:
					RunApp();
					break;
				default:
					System.out.println("Your choose doesn't have\n");
					break;
				}
			} while (choose < 0 || choose > 2);
		} catch (Exception e) {
			System.out.println("Error!!!");
			UpdateStore();
		}
	}
	
	public static void AddMediaToStore() {
		int choose;
		String title;
		String category;
		float cost;
		try {
			do {
				System.out.println("Please enter type of media: ");
				System.out.println("1. Book");
				System.out.println("2. Compact Disc");
				System.out.println("3. Digital Video Disc");
				System.out.println("0. Cancel");
				System.out.println("Your choose is: ");
				choose = sr.nextInt();
				sr.nextLine();
				switch (choose) {
				case 1:
					System.out.println("Enter book title: ");
					title = sr.nextLine();
					System.out.println("Enter book category: ");
					category = sr.nextLine();
					System.out.println("Enter book cost: ");
					cost = sr.nextFloat();
					sr.nextLine();
					Aims.store.addMedia(new Book(title, category, cost));
					break;
				case 2:
					System.out.println("Enter CD title: ");
					title = sr.nextLine();
					System.out.println("Enter CD category: ");
					category = sr.nextLine();
					System.out.println("Enter CD cost: ");
					cost = sr.nextFloat();
					sr.nextLine();
					Aims.store.addMedia(new CompactDisc(title, category, cost));
					break;
				case 3:
					System.out.println("Enter DVD title: ");
					title = sr.nextLine();
					System.out.println("Enter DVD category: ");
					category = sr.nextLine();
					System.out.println("Enter DVD cost: ");
					cost = sr.nextFloat();
					sr.nextLine();
					Aims.store.addMedia(new DigitalVideoDisc(title, category, cost));
					break;
				case 0:
					UpdateStore();
				default:
					System.out.println("Your choose doesn't have\n");
					break;
				}
			} while (choose < 0 || choose > 3);
		} catch (Exception e) {
			System.out.println("Error!!!");
			UpdateStore();
		}
	}
	
	public static void RemoveMediaStore() {
		String title;
		System.out.println("Please enter the title of the media: ");
		title = sr.nextLine();
		sr.nextLine();
		for (Media media : Aims.store.getItemInStore()) {
			if (media.getTitle().compareTo(title) == 0) {
				Aims.store.removeMedia(media);
			}
		}

	}
	
	public static void SeeCart() {
		int choose;
		try {
			do {
				Aims.cart.viewCart();
				System.out.println("-------------------------------------------------------");
				Menu.cartMenu();
				choose = sr.nextInt();
				sr.nextLine();
				switch (choose) {
				case 1:
					FilterCart();
					break;
				case 2:
					SortCart();
					break;
				case 3:
					RemoveMediaCart();
					SeeCart();
					break;
				case 4:
					PlayMediaCart();
					SeeCart();
					break;
				case 5:
					PlaceOrder();
					SeeCart();
					break;
				case 0:
					RunApp();
					break;
				default:
					System.out.println("Your choose doesn't have\n");
					break;
				}
			} while (choose < 0 || choose > 5);
		} catch (Exception e) {
			System.out.println("Error!!!");
			SeeCart();
		}
		
	}
	
	public static void RemoveMediaCart() {
		String title;
		System.out.println("Please enter the title of the media: ");
		title = sr.nextLine();
		for (Media media : Aims.cart.getItemsOrdered()) {
			if (media.getTitle().compareTo(title) == 0) {
				Aims.cart.removeMedia(media);
			}
		}
	}
	
	public static void SortCart() {
		int choose;
		try {
			do {
				System.out.println("Sort medias by title or cost?");
				System.out.println("1. Title");
				System.out.println("2. Cost");
				System.out.println("0. Back");
				System.out.println("Your choose is: ");
				choose = sr.nextInt();
				sr.nextLine();
				switch (choose) {
				case 1:
					SortTitleCost();
					SeeCart();
					break;
				case 2:
					SortCostTitle();
					SeeCart();
				case 3:
					SeeCart();
				default:
					System.out.println("Your choose doesn't have\n");
					break;
				}
			} while (choose < 0 || choose > 2);
		} catch (Exception e) {
			System.out.println("Error!!!");
			SeeCart();
		}
	}
	
	public static void SortTitleCost() {
		Collections.sort(Aims.cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
		Aims.cart.viewCart();
	}
	public static void SortCostTitle() {
		Collections.sort(Aims.cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
		Aims.cart.viewCart();
	}
	
	public static void FilterCart() {
		int choose;
		try {
			do {
				System.out.println("Filter medias by title or cost?");
				System.out.println("1. Title");
				System.out.println("2. Id");
				System.out.println("0. Back");
				System.out.println("Your choose is: ");
				choose = sr.nextInt();
				sr.nextLine();
				switch (choose) {
				case 1:
					FilterTitle();
					SeeCart();
					break;
				case 2:
					FilterId();
					SeeCart();
					
				case 3:
					SeeCart();
				default:
					System.out.println("Your choose doesn't have\n");
					break;
				}
			} while (choose < 0 || choose > 2);
		} catch (Exception e) {
			System.out.println("Error!!!");
			SeeCart();
		}
	}
	
	public static void FilterTitle() {
		String title;
		int i = 0;
		System.out.println("Please enter the title of the media: ");
		title = sr.nextLine();
		sr.nextLine();
		for (Media media : Aims.cart.getItemsOrdered()) {
			if(media.getTitle().compareTo(title) == 0) {
				i++;
				System.out.println(media.toString());
			}
		}
		if (i == 0) {
			System.out.println("Don't have this media");
		}
	}
	
	public static void FilterId() {
		int id;
		int i = 0;
		System.out.println("Please enter the title of the media: ");
		id = sr.nextInt();
		sr.nextLine();
		for (Media media : Aims.cart.getItemsOrdered()) {
			if(id == media.getId()) {
				i++;
				System.out.println(media.toString());
			}
		}
		if (i == 0) {
			System.out.println("Don't have this media");
		}
	}
	
	public static void PlaceOrder() {
		System.out.println("An order is created.");
		Aims.cart.removeAllMedia();
	}

}
