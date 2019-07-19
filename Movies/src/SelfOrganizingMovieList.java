
public class SelfOrganizingMovieList implements MovieList {

	DLL movieList;

	public SelfOrganizingMovieList() {
		movieList = new DLL();
	}

	@Override
	public int size() {
		return movieList.getSize();
	}

	@Override
	public boolean isEmpty() {
		return movieList.isEmpty();
	}

	@Override
	public boolean searchMovie(String title) {
		if (movieList.makeHead(title)) {
			return true;
		}
		return false;
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
