/** Created by stasa on 18.5.17..   */

import java.util.*;

public class Solution
{
    public ArrayList<Movie> getMovieRecommendations (Movie movie, int N)
    {
        // The basic idea:
        // The first step is BFS (Breadth first search ),
        // then sort out all the movies in descending order by rating,
        // and finally take the first N

        Queue<Movie> q = new ArrayDeque<Movie>();
        ArrayList<Movie> visited = new ArrayList<Movie>();

        q.add(movie);
        visited.add(movie);

        while (!q.isEmpty() )
        {
            // poll() Retrieves and removes the head of this queue,
            // or returns null if this queue is empty.
            Movie curr = q.poll();

            for (Movie x : curr.getDirectConections()){
                if (!visited.contains(x)){
                    visited.add(x);
                    q.add(x);
                }
            }
        }

        Collections.sort(visited, new SortbyRating());

        visited.subList(4,visited.size()).clear();

        return visited;
    }

    public static void main(String[] args)
    {
        Movie[] movies = new Movie[9];
        movies[1] = new Movie(1, 6.2f);
        movies[2] = new Movie(2, 3.6f);
        movies[3] = new Movie(3, 2.4f);
        movies[4] = new Movie(4, 9.8f);
        movies[5] = new Movie(5, 5.1f);
        movies[6] = new Movie(6, 8.4f);
        movies[7] = new Movie(7, 9.9f);
        movies[8] = new Movie(8, 8.7f);

        movies[1].addDirectConections(movies[2]);
        movies[1].addDirectConections(movies[3]);
        movies[1].addDirectConections(movies[4]);

        movies[2].addDirectConections(movies[1]);
        movies[2].addDirectConections(movies[5]);

        movies[3].addDirectConections(movies[1]);
        movies[3].addDirectConections(movies[5]);

        movies[4].addDirectConections(movies[1]);
        movies[4].addDirectConections(movies[6]);
        movies[4].addDirectConections(movies[7]);

        movies[5].addDirectConections(movies[2]);
        movies[5].addDirectConections(movies[3]);

        movies[6].addDirectConections(movies[4]);
        movies[6].addDirectConections(movies[7]);

        movies[7].addDirectConections(movies[4]);
        movies[7].addDirectConections(movies[6]);
        movies[7].addDirectConections(movies[8]);

        movies[8].addDirectConections(movies[7]);

        ArrayList<Movie> result = (new Solution()).getMovieRecommendations(movies[1], 4);
        
        System.out.println( "Returned " + result.size() + " movie(s)" );

        for (Movie m : result){
            System.out.println( m.getId() + "  "+ m.getRating());
        }
    }
}

