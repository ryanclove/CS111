/*
*
* This class implements a library of songs
*
* @author CS111 - Rutgers University
*
*/
public class SongApp {

  private Song[] items;      // keep Songs in an unsorted array
  private int numberOfItems; // number of Songs in the array

  /*
  * Default constructor creates array with capacity for 5 Songs
  */
  SongApp () {
      // ADD YOUR CODE HERE
      items = new Song[5];
      this.numberOfItems = 0;
  }

  /*
  * One argument constructor creates array with user defines capacity
  *
  * @param capacity defines the capacity of the Song library
  */
  SongApp (int capacity) {
      items = new Song[capacity];
      this.numberOfItems = 0;
  }

  /*
  * Add a Song into the library (unsorted array)
  *
  * If the library is full (there is not enough space to add another Song)
  *   - create a new array with double the size of the current array.
  *   - copy all current Songs into new array
  *   - add new Song
  *
  * @param m The Song to be added to the libary
  */
  public void addSong (Song m) {
      if(numberOfItems < items.length){
        items[numberOfItems] = m;
        this.numberOfItems++;
      }
      else{

        Song[] newList = new Song[items.length * 2];
        int i;
        for (i = 0; i<this.numberOfItems; i++){
          newList[i] = items[i];
        }
        newList[items.length] = m;
        this.numberOfItems++;

        items = newList;
      }
  }

  /*
  * Removes a Song from the library. Returns true if Song is removed, false
  * otherwise.
  * The array should not become sparse after a remove, that is, all Songs
  * should be in consecutive indexes in the array.
  *
  * @param m The Song to be removed
  *
  */
  public boolean removeSong (Song m) {
      // ADD YOUR CODE HERE
      if (getNumberOfItems() == 0) {
        return false;
      }
      for (int i = 0; i < getNumberOfItems() ; i ++ ) {
        if (items[i].equals(m)) {
          items[i] = items[getNumberOfItems()-1];
          items[getNumberOfItems()-1] = null;
          this.numberOfItems --;
          return true;
        }
      }
      return false;
  }

  /*
  * Returns the library of songs
  *
  * @return The array of Songs
  */
  public Song[] getSongs () {
      // ADD YOUR CODE HERE

      return items;
  }

  /*
  * Returns the current number of Songs in the library
  *
  * @return The number of items in the array
  */
  public int getNumberOfItems () {
      // ADD YOUR CODE HERE
      return this.numberOfItems;
  }

  /*
  * Update the rating of Song @m to @rating
  *
  * @param @m The Song to have its ratings updated
  * @param @rating The new rating of @m
  * @return tue if update is successfull, false otherwise
  *
  */
  public boolean updateRating (Song m, int rating) {
      // ADD YOUR CODE HERE
      for (int i = 0;i < getNumberOfItems() ;i++ ) {
        if (items[i].equals(m)) {
          items[i].setRating(rating);
          return true;
        }
      }
      return false;
  }

  /*
  * Prints all Songs
  */
  public void print () {
      // ADD YOUR CODE HERE
      System.out.println("     Name - Year - Rating - Writers");
      for (int i = 0; i < getNumberOfItems() ;i++ ) {
        System.out.println("Song " + (i+1) + " " + items[i].toString());
      }
  }

  /*
  * Return all the Songs by @songwriter. The array size should be the
  * number of Songs by @songwriter.
  *
  * @param songwriter The songwriter's name
  * @param An array of all the Songs by @songwriter
  *
  */
  public Song[] getSongsBySongwriter (String songwriter) {
      // ADD YOUR CODE HERE
      int count = 0;
      for (int i = 0; i < getNumberOfItems() ; i++ ) {
        for (int j = 0;j < items[i].getNumberOfWriters() ;j++ ) {
          if ((items[i].getWriterAtIndex(j)).equals(songwriter)) {
            count ++;
            break;
          }
        }
      }
      Song[] songsByWriter = new Song[count];
      int songCountByWriter = 0;
      for (int i = 0; i < getNumberOfItems() ; i++ ) {
        for (int j = 0;j < items[i].getNumberOfWriters() ;j++ ) {
          if ((items[i].getWriterAtIndex(j)).equals(songwriter)) {
            songsByWriter[songCountByWriter] = items[i];
            songCountByWriter++;
            break;
          }
        }
      }
      return songsByWriter;
  }

  /*
  * Return all the Songs released in @year. The array size should be the
  * number of Songs made in @year.
  *
  * @param year The year the Songs were made
  * @return An array of all the Songs made in @year
  *
  */
  public Song[] getSongsByYear (int year) {
      // ADD YOUR CODE HERE
      int count = 0;
      for (int i = 0; i < getNumberOfItems() ; i++ ) {
        if (items[i].getYear() == year) {
          count ++;
        }
      }
      Song[] songsByYear = new Song[count];
      int songCountByYear = 0;
      for (int i = 0; i < getNumberOfItems() ; i++ ) {
        if (items[i].getYear() == year) {
          songsByYear[songCountByYear] = items[i];
          songCountByYear ++;
        }
      }
      return songsByYear;
  }

  /*
  * Return all the Songs with ratings greater then @rating
  *
  * @param rating
  * @return An array of all Songs with rating greater than @rating
  *
  */
  public Song[] getSongsWithRatingsGreaterThan (int rating) {
      // ADD YOUR CODE HERE
      int count = 0;

      for (int i = 0; i < getNumberOfItems() ; i++ ) {
        if (items[i].getRating() > rating) {
          count ++;
        }
      }
      Song[] songsByRating = new Song[count];
      int songCountByRating = 0;
      for (int i = 0; i < getNumberOfItems() ; i++ ) {
        if (items[i].getRating() > rating) {
          songsByRating[songCountByRating] = items[i];
          songCountByRating ++;
        }
      }
      return songsByRating;
  }

  /*
  * Search for Song name @name using binary search algorithm.
  * Assumes items is sorted
  */
  public Song searchSongByName (String name) {
      // ADD YOUR CODE HERE
      int left = 0, right = getNumberOfItems()-1;
      while(left <= right){
        int mid = (left + right)/2;
        if (items[mid].getName().compareTo(name) == 0) {
          return items[mid];
        }
        if (items[mid].getName().compareTo(name) > 0) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
      return null;
  }

 /*
  * Sorts Songs by year using insertion sort
  */
  public void sortByYear () {
      // ADD YOUR CODE HERE
      int itemsSorted;
      for(itemsSorted = 1; itemsSorted < getNumberOfItems(); itemsSorted++){
        int temp = items[itemsSorted].getYear();
        Song tempSong = items[itemsSorted];
        int loc = itemsSorted - 1;
        while (loc>=0 && items[loc].getYear() > temp) {
          items[loc+1] = items[loc];
          loc --;
        }
        items[loc + 1] = tempSong;
      }
  }

 /*
  * Sorts array of Songs by name using selection sort
  */
  public void sortByName () {
      // ADD YOUR CODE HERE
      for (int lastPlace = getNumberOfItems()-1 ; lastPlace>0 ; lastPlace -- ) {
        int maxLoc = 0;
        for (int j = 1; j <= lastPlace ;j++ ) {
          if ((items[j].getName()).compareTo(items[maxLoc].getName()) > 0) {
            maxLoc = j;
          }
        }
        Song temp = items[maxLoc];
        items[maxLoc] = items[lastPlace];
        items[lastPlace] = temp;
      }
  }

 /*
  * Search for Song name using recursive linear search
  * @param name The name of the song to search
  * @param Songs The array containing all songs
  * @param l The left index
  * @param r The right index
  * @return The song with name @name or null if song is not found
  */
  public static Song searchSongByName (String name, Song[] Songs, int l, int r) {
      // ADD YOUR CODE HERE
      if (Songs[l] == null) {
        return null;
      }
      if (l >= r) {
        return null;
      }else if (name.equals(Songs[l].getName())) {
        return Songs[l];
      }else {
        return searchSongByName(name, Songs, l + 1, r );
      }
  }
}
