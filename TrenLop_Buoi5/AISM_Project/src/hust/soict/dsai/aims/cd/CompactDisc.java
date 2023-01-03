package hust.soict.dsai.aims.cd;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.playable.Playable;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	private static int nbCompactDisc = 0;

	public CompactDisc(String title, String category, String artist, String detector, int length, float cost) {
		super(title, category, detector, length, cost);
		this.artist = artist;
		nbCompactDisc++;
		super.setId(nbCompactDisc);
	}

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
		nbCompactDisc++;
		super.setId(nbCompactDisc);
	}
	
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void addTrack(Track trackName) {
		if (tracks.contains(trackName) == true) {
			System.out.println("The track has been already ");
		}else {
			tracks.add(trackName);
			System.out.println("The track has been added");
		}
	}
	
	public void removeTrack(Track trackName) {
		if (tracks.size() == 0) {
			System.out.println("Don't have track in list");
		}else if(tracks.contains(trackName) == false){
			System.out.println("The track hasn't been in list");
		}else {
			tracks.remove(trackName);
			System.out.println("The track has been deleted");
		}
	}
	
	public int getLength() {
		int CDLength = 0;
		for (Track track : tracks) {
			CDLength +=track.getLength();
		}
		return CDLength;
	}

	@Override
	public void play() {
		for (Track track : tracks) {
			System.out.println("Playing DVD: " + track.getTitle());
			System.out.println("DVD length: " + track.getLength());	
			System.out.println();
		}
	}
	public String toString() {
		return super.getTitle() + "\t\t" + super.getCatogary() + "\t\t" + getArtist() + "\t\t" + super.getDetector() + "\t\t" + super.getLength() + "\t\t" + super.getCost() + "\n";
	}
}
