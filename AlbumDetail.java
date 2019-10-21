// Name: Ramesh Chapagain            Date Assigned: 25th September 2019
//
// Course: CSCI 2073 sec #40416      Date Due: 4th October 2019
//
// Instructor: Jose L. Cordova, Ph.D
//
// File name: AlbumDetail.java
//
// Program Description: This class stores the information of each albums on the AlbumDetail objects and 
//      passes the value to AlbumList class for further processing. 

/**
   This class stores the information of each albums on the AlbumDetail objects and 
    passes the value to AlbumList class for further processing. 

*/

public class AlbumDetail
{
   
   //Initialization of instance variables
   private int num;    
   private int date;
   private String title;
   private String artist;
   
   /**
      Initialization of AlbumDetail object variables
      @param num postion of top list
      @param date Year of the album
      @param title Title of album
      @param artist Name of the artist
   */
   public AlbumDetail(int num, int date, String title, String artist)
   {
      this.num = num;
      this.date = date;
      this.title = title;
      this.artist = artist;
   }
   
   
   /**
      Returns the number of postion on the top list
      @return number of positon of top list
   */
   public int getNum()
   {
      return num;
   }
   
   
   /**
      Returns the Year of the album release
      @return year of the album 
   */
   public int getDate()
   {
      return date;
   }
   
   
   /**
      Returns the title of the album
      @return title of the album
   */
   public String getTitle()
   {
      return title;
   }
   
   
   /**
      Returns name fo the artist
      @return name of artist 
   */
   public String getArtist()
   {
      return artist;
   }
   
   
   /**
      toString method for the formatted output of the details of the albums
      @return formatted output of the albums on the ArrayList
   */
   public String toString()
   {
      String display1 = String.format("%-8s%-3s%-5s%-3s%-65s%-3s%-58s%-3s", ("| " + this.num), " | ", this.date, " | ", this.title,  " | ",  this.artist , " | \n");
      String display = "";`      `
      for (int i = 1; i<148 ; i++)
      {
         display = display + "-";
      }
      return display1 + display;
      
   }
}