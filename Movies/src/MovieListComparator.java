import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class MovieListComparator {
	public final static String[] movieCollection = { "Casablanca", "Cast Away", "Forrest Gump", "Ghost", "Gladiator",
			"Midnight Cowboy", "One Flew Over the Cuckoo's Nest", "The Dead Poet Society", "The Godfather", "Tootsie" };
	OrdinaryMoveList list1;
	SelfOrganizingMovieList list2;
	String[] accessedMovies = new String[100000];

	/* constructor */
	public MovieListComparator() {
		list1 = new OrdinaryMoveList();
		list2 = new SelfOrganizingMovieList();
	}

	/* store movieCollection in an empty movieList */
	public void storeInList(MovieList list) {
		for (int i = 0; i < movieCollection.length; i++) {
			list.insert(movieCollection[i]);
		}
	}

	/*
	 * from a given file, read a list of previously accessed movies (one title per
	 * line), and store the list in accessedMovies array
	 */
	public void readAccessedMovies(String filename) {
		try {
			File newFile = new File(filename);
			BufferedReader file = new BufferedReader(new FileReader(newFile));
			String line;
			int i = 0;
			while ((line = file.readLine()) != null) {
				accessedMovies[i] = line;
				i++;
			}
			file.close();
		} catch (Exception e) {
			System.out.println("cant find file");
		
		}
	}
	/*
	 * within main method of MovieListComparator, the following should be executed:
	 * 1. Create instances of list1 and list2, and store the content of
	 * MovieCollection array in each; 2. Prompt the user for the name of the file
	 * with a previous access record, and store this list in the accessedMovies
	 * array; 3. By using SearchTimer class, measure the times required to search
	 * movie titles from accessedMovies in list1 and list2; 4. Print out the results
	 * from (3), and state which list provides a better overall performance for the
	 * given access record; and 5. Print out each title from movieCollection, and
	 * the number of times it has been accessed during (3).
	 */
	public static void main(String[] args) {
		MovieListComparator ml = new MovieListComparator();
		ml.storeInList(ml.list1);
		ml.storeInList(ml.list2);
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter Filename: ");
		String filename = reader.nextLine();
		ml.readAccessedMovies(filename);
		
		SearchTimer ordinary = new SearchTimer(ml.list1);
		SearchTimer sort = new SearchTimer(ml.list2);
		long ordinaryTime = ordinary.measure(ml.accessedMovies, ml.accessedMovies.length);
		long sortTime = sort.measure(ml.accessedMovies, ml.accessedMovies.length);
		
		System.out.format("Result time for Ordinary List is : %d\n", ordinaryTime);
		System.out.format("Result time for Self Orginizing List is : %d\n", sortTime);
		
		if (ordinaryTime > sortTime) {
			System.out.println("Self Orginizing List has a better performance");
		}
		if (sortTime > ordinaryTime) {
			System.out.println("Ordinary List has a better performance");
		}
		System.out.println("\nOrdinary List access amount:");
		while(!ml.list1.isEmpty()) {
			Movie p = ml.list1.movieList.removeFirst();
			System.out.format("%s: %d\n", p.element(),p.accessCount());
		}
		System.out.println("\nSelf Orginizing List access amount:");
		while(!ml.list2.isEmpty()) {
			Movie p = ml.list2.movieList.removeFirst();
			System.out.format("%s: %d\n", p.element(),p.accessCount());
		}
	}
}
