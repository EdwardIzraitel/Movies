
public class SearchTimer {
    /*  class variables  */ 
    MovieList ML;
    int executionTime;

    /*  constructor  */
    public SearchTimer(MovieList L) {
        ML = L;
    }

    /*  perform searches for testTitles on ML,
        and return the overall execution time in milliseconds
    */
    public long measure(String[] testTitles, int numberOfTestTitles) {
    	long start =  System.currentTimeMillis();
    	int pos;
    	for(pos =0;pos<numberOfTestTitles;pos++) {
    		ML.searchMovie(testTitles[pos]);
    	}
    	long end = System.currentTimeMillis();
    	return end-start;
    } 
}
