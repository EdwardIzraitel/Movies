
public class OrdinaryMoveList implements MovieList {

	DLL movieList;

	public OrdinaryMoveList() {
		movieList = new DLL();
	}

	public int size() {
		return movieList.getSize();
	}

	@Override
	public boolean isEmpty() {
		return movieList.isEmpty();
	}

	@Override
	public boolean searchMovie(String title) {
		return movieList.search(title);
	}

	@Override
	public String remove(Movie p) {
		return movieList.remove(p);
	}

	@Override
	public Movie insert(String title) {
		Movie newest = new Movie(title,0);
		movieList.addFirst(newest);
		return newest;
	}

}
