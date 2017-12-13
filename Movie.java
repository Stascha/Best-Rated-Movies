/** Created by stasa on 18.5.17.. */

import java.util.ArrayList;
import java.util.List;

public class Movie
{
    private int movieId;
    private float rating;
    private ArrayList<Movie> directConections;

    public Movie(int movieId, float rating)
    {
        this.movieId = movieId;
        this.rating = rating;
        directConections = new ArrayList<Movie>();
    }

    public int getId() {
        return movieId;
    }

    public float getRating() {
        return rating;
    }

    public void addDirectConections(Movie movie) {
        directConections.add(movie);
    }

    public List<Movie> getDirectConections() {
        return directConections;
    }
}
