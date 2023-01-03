package hust.soict.dsai.aims.disc;

import hust.soict.dsai.aims.cd.Disc;
import hust.soict.dsai.aims.playable.Playable;

public class DigitalVideoDisc extends Disc implements Playable{
	private static int nbDigitalVideoDisc = 0;
	
	public DigitalVideoDisc(String title, String category, String detector, int length, float cost) {
		super(title, category, detector, length, cost);
		nbDigitalVideoDisc++;
		super.setId(nbDigitalVideoDisc);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
		nbDigitalVideoDisc++;
		super.setId(nbDigitalVideoDisc);
	}

	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());		
	}
	
	public String toString() {
		return super.getTitle() + "\t\t" + super.getCatogary() + "\t\t" + super.getDetector() + "\t\t" + super.getLength() + "\t\t" + super.getCost() + "\n";
	}
}
