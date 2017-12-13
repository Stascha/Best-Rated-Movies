/** Created by stasa on 18.5.17..   */

import java.util.Comparator;

class SortbyRating implements Comparator<Movie>{
      
      // Used for sorting in descending order of Rating
      public int compare(Movie a, Movie b){
          return a.getRating() <  b.getRating() ?  1 : -1 ;
      }
}
