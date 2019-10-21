// Name: Ramesh Chapagain            Date Assigned: 25th September 2019
//
// Course: CSCI 2073 sec #40416      Date Due: 4th October 2019
//
// Instructor: Jose L. Cordova, Ph.D
//
// File name: AlbumList.java
//
// Program Description: This program access the file containing albums and process the list and extract key information about the
//                      top albums, the top artists, and their respective musical decades. 


/**
   Imports java utility and io packages
*/
import java.util.*;
import java.io.*;


/**
   This class uses an ArrayList to store objects containing album information
    and process and extract information about different aspects of albums
*/
public class AlbumList
{
   
    //Declaring ArrayList with an initial size 10
   List <AlbumDetail> albums =  new ArrayList<AlbumDetail>();


   /**
      This method helps display the formatted output in addition to the display by toString in AlbumList class
      @return formatted output header
   */
   public String Display()
   {
      String display1 = "";
      for (int i = 1; i<148 ; i++)
      {
         display1 = display1 + "-";
      }
      return display1+"\n" + String.format("%-8s%-3s%-5s%-3s%-65s%-3s%-58s%-3s", ("| " + "Number"), " | ", "Year", " | ", "Title",  " | ",  "Artist", " | ") + "\n" +display1 + " \n" ;
      
   }  
     
   
   /**
      Construct an empty list of with an initial capacity of ten.
   */
   public AlbumList()
   {
      
   }
   
   
   /**
      This method processes the file and extracts the information about the albums in the file,
      creates new objects of AlbumDetail class and adds it in ArrayList,     
      checks for the exceptions, and
      @param fileName name of the file containing albums
      @return false if exception occurs
   */
      
   public boolean readAlbums(String fileName)
   {
      
      albums.clear();   //clears albums list
      
      /**
         Allows you to define a block of code to be tested for errors 
         while it is being executed
      */
      try
      {
         
         File infile = new File(fileName);   //Create a new file object passing a string that represents the name of a file
         Scanner in = new Scanner(infile);   //Create a new Scanner object taking input a file
         
         String firstLine = in.nextLine();   //Read the first line of from the file
         
         
         //Execcute until there is next line in the file
         while(in.hasNextLine())
         {
            
            String line = in.nextLine();  //Put all the contents of line on string line
                       
            String[] values = line.split(",");     //Split the string values of the line seperated by commas
           
           
            int num = Integer.parseInt(values[0]);    //Convert the first value of the line to integer and set it as num
            int date = Integer.parseInt(values[1]);   //Convert the second value of the line to integer and set it as date
            String title = values[2];                 //Set the third value as title 
            String artist = values[3];                //Set the fourth value as artist name
            AlbumDetail totalContent = new AlbumDetail(num,date,title,artist);   //Create a new AlbumDetail object with the above information
            albums.add(totalContent);           //Adds an AlbumDetail object to albums Arraylist
         }  
         return true;       
      }
      
      
      /**
         It allows you to define a block of code to be executed if FileNotFoundException occurs in the try block.
      */
      catch (FileNotFoundException e)
      {
         System.out.println(e.getMessage());    //Prints the exception message
         return false;                          //Returns false
      }
      
      
      /**
         It allows you to define a block of code to be executed if NumberFormatException occurs in the try block.
      */
      catch (NumberFormatException e)
      {
         System.out.println(e.getMessage());    //Prints the exception message
         return false;                          //Returns false
      }
      
      
      /**
         It allows you to define a block of code to be executed if IndexOutOfBoundsException occurs in the try block.
      */
      catch (IndexOutOfBoundsException e)
      {
         System.out.println(e.getMessage());    //Prints the exception message
         return false;                          //Returns false
      }
      
      
      /**
         It allows you to define a block of code to be executed if NullPointerException occurs in the try block.
      */
      catch (NullPointerException e)
      {
         System.out.println(e.getMessage());    //Prints the exception message
         return false;                          //Returns false
      }
      
      
      /**
         It allows you to define a block of code to be executed if NoSuchElementException occurs in the try block.
      */
      catch (NoSuchElementException e)
      {
         System.out.println(e.getMessage());    //Prints the exception message
         return false;                          //Returns false
      }
      
      
      /**
         It allows you to define a block of code to be executed if other exceptions occurs in the try block.
      */
      catch (Exception e)
      {
         System.out.println(e.getMessage());    //Prints the exception message
         return false;                          //Returns false
      }
      
   }
   
   
   /**
      This method returns the total no of albums from the Arraylist of albums
      @return size of the albums
   */
   public int total()
   {
      return albums.size();      //Returns size of the albums
   }
   
   
   /**
      This method returns the details about top n albums,
      if n is greater than the total albums then n is set to the size equal to num of albums
      @param n top n albums
      @return details about the top n albums
   */
   public String topAlbums(int n)
   {
      
      //Sets n to size of album if it is greater than the size of the album
      if(n > albums.size())
      {
         n = albums.size();
      }
      
      
      String details="";   //Declare and initialize variable to be used
      
      //Loop for n albums of the list
      for (int i = 0; i < n; i++)
      {
         details= details+(albums.get(i)+"\n");    //Add details about the group of albums
      }
     
      return this.Display() + details;         //Return details about the top n albums
   }
   
   /**
      This method returns the details about top n albums,
      @return details about the top albums
   */
   public String topAlbums()
   {
      
      String details="";   //Declare and initialize variable to be used
      
      //Loop through all the albums in the ArrayList
      for( int i = 0; i<albums.size(); i++)
      {
         details = details + (albums.get(i)+"\n");    //Add the details of the albums to print
      }
      
      return this.Display() + details;            //return the details about the top albums
   }
   
   
   /**
      This method returns details about the albums by a particular artist and count the number of albums 
      @param artist name of artist
      @return number of albums by a particular artist
   */
   public int display(String artist)
   {
      int counter = 0;     //Declare and initialize counter variable
      
      String details="";   //Declare and initialize details variable to be used
      
      
      //Loop through all the albums      
      for( int i = 0; i<albums.size(); i++)
      {
         //Check whether the artist in the ArrayList of albums match a particular artist   
         if((albums.get(i).getArtist()).equals(artist))
         {
            details = details + (albums.get(i)+"\n");    //Add the details of the albums of a particular artist
            counter++;  //increase counter variable by 1
         }
      }
      
      
      //displays a formatted list of albums released by the artist specified as argument
      System.out.println(this.Display()+ details);   
   
      return counter;      //returns num of albums
   }
   
   
   /**
      Displays a formatted list of albums released during the decade specified as argument
      @param decade decades of albums to be displayed
      @return number of albums in the particular decades
   */
   public int display(int decade)
   {
      int counter = 0;     //declare and initialize the counter variable
      String details="";   //declare and initialize details variable to be used
      
      //Loop through all the albums in the arrayList
      for( int i = 0; i<albums.size(); i++)
      {
         
         //Check and execute if the year range of date in albums in Arraylist fall in particular decade
         if((albums.get(i).getDate()) < (decade + 10) && (albums.get(i).getDate()) >= decade )
         {
            details = details + (albums.get(i)+"\n");    //Add the details of albums to be displayed
            counter++;        //increase the counter by 1
         }
      }
      //displays a formatted list of albums released by the artist specified as argument
      System.out.println(this.Display() + details); 
      
      return counter;                  //Returns the number of albums in the particular decade
   }
   
   
   /**
      Returns the artist with the largest number of albums in the list
      @return top artist of the list
   */
   public String topArtist()
   {
      
      String max = "";     //declare and initialize the name of artist with max value(Setting it with no value initially)
      
      int maxValue =0;     //declare and initialize the max value
      
      //Loop while size of album is greater than 0
      while(albums.size()>0)
      {
         
         int counter = 1;     //Declare and initialize the counter variable
         
         //Loop for the size of the arrayList of albums
         for (int j = 1; j<albums.size();j++)
         {            
         
            //Check for all the artists of the albums in the list of the albums and execute if they match
            if((albums.get(0).getArtist()).equals(albums.get(j).getArtist()))
            {
               counter++;        //increase counter variable by 1
               albums.remove(j); //remove particular album from the list if its artist match
            }
         }
         
         //Check if counter is greater than maxValue and execute the block        
         if (counter > maxValue )
         {
            maxValue = counter;              //set the maxValue to counter
            max = albums.get(0).getArtist(); //set the max artist to the artist corresponding to maxValue
         }
         
         albums.remove(0);       //Remove the album from the list once its artist is checked
      }
      
      return max;          //Return artist with maxmum albums
   }
}