public class Song
{
   private String name; //name of the song
   private int year;//year released
   private int numberOfWriters; //writers count
   private String writers[]; //array of song composers
   private int rating;//an integer from 1 to 5

   //Constructor with song name as parameter
   public Song(String name)
   {
       this.name=name; //assign name
       numberOfWriters=year=0;//default 0's
       writers=new String[50];//allocate string array max of 50 writers
       rating=0;//intially rating is 0
   }

   //Getter and setters
   public void setName(String name)
   {
       this.name=name;
   }

   public String getName()
   {
       return name;
   }

   public void setYear(int year)
   { this.year=year;}

   public int getYear()
   { return year;}

   public void setRating(int rating)
   { this.rating=rating;}

   public int getRating()
   { return rating;}

   //Add writer method
   public void addWriter(String writer)
   {
       if(numberOfWriters<5) //when maximum 5 writers are reached
           this.writers[numberOfWriters++]=writer; //assign writer at first empty postion
   }

   //get writers method
   public String[] getWriters()
   {
       return writers;//returns array of writers
   }

   //method get no.of writers
   public int getNumberOfWriters()
   {
       return numberOfWriters;
   }

   //method writer at index
   public String getWriterAtIndex(int index)
   {
       if(index>=numberOfWriters) //when invalid index of writer
           return null;//return nothing
       else //when valid index
           return writers[index];//return writer name
   }

   public String toString()
   {
       String details=name + ", " + year + ", " + rating;//make a string details
       return details; //return it
   }

   //Equals method
   public boolean equals(Object other) {
  if (other instanceof Song) {
   Song otherSong;
   int count = 0;
   int writerCount1 = 0;
   int writerCount2 = 0;
   String s = "";
   otherSong = (Song)(other);
   if ((this.getName()).equals(otherSong.getName()) && this.getYear() == otherSong.getYear()) {
    for (int i = 0; i < 50; i++) {
     if ((this.getWriters()[i]) != null) {
      writerCount1++;
     }
    }
    for (int i = 0; i < 50; i++) {
     if ((otherSong.getWriters())[i] != null) {
      writerCount2++;
     }
    }
    if (writerCount1 == writerCount2) {
     for (int i = 0; i < writerCount1; i++) {
      if ((this.getWriters())[i] != null) {
       for (int j = 0; j < writerCount2; j++) {
        if ((otherSong.getWriters())[j] != null) {
         if (((this.getWriters())[i]).equals((otherSong.getWriters())[j])) {
          count++;
          break;
         }
        } else {
         break;
        }
       }
      } else {
       break;
      }
     }
     if (count == writerCount1) {
      return true;
     } else {
      return false;
     }
    } else {
     return false;
    }
   } else {
    return false;
   }
  } else {
   return false;
  }
 }


   //Compare to method
   public int compareTo(Song other)
   {
       return name.compareTo(other.name);//this returns 1,0,-1
   }

   //Writing main program
   public static void main(String args[])
   {
       Song s1=new Song("Bohemian Rhapsody");//create song
       s1.setYear(1987);
       s1.setRating(5);
       s1.addWriter("Queen");
       s1.addWriter("Queen");
       System.out.println(s1);//this calls toString
       String writers[]=s1.getWriters();//get writers
       for(int i=0;i<s1.getNumberOfWriters();i++) //repeat loop
           System.out.println(writers[i]);//print each writer
   }
}
