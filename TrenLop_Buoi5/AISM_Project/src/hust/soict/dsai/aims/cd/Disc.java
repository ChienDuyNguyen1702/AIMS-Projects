package hust.soict.dsai.aims.cd;

import hust.soict.dsai.aims.media.Media;

public class Disc extends Media{
	private int length;
	private String detector;
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getDetector() {
		return detector;
	}
	public void setDetector(String detector) {
		this.detector = detector;
	}
	public Disc(String title, String category, String detector, int length, float cost) {
		super(title, category, cost);
		this.detector = detector;
		this.length = length;
	}
	public Disc(String title, String categoru, float cost) {
		super(title,categoru, cost);
	}
	
}
