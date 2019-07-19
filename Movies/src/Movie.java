
public class Movie {
	private int count;
	private String movieName;

	public Movie(String name, int z) {
		this.count = z;
		this.movieName = name;
	}

	public String element() {
		return movieName;
	}

	public int accessCount() {
		return count;
	}

	public void addCount() {
		count++;
	}
}
