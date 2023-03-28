import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**********************
 * Files: Pokedex.java, Pokemon.csv
 * Author: Mohamedamin Mohamed
 * Contact mohamedamin204080@gmail.com
 * created: 10/05/2022
 * Modified:03/28/2023
 * Description:
 * This program prompts the user if they would like to search a pokedox 
by name or by number, then returns the Pokédex entry that informs the user 
of the number, classification, description, type1 and
type2
 * 
 **********************/

public class main {
  public static void main(String[] args) throws IOException {
    
    Scanner scan = new Scanner(System.in);
    
    //file to be used to store the pokedox entries
    File file = new File("Pokemon.csv");
    
    //arraylists to store the respective name and numbers of the pokedox
    ArrayList<String> name = new ArrayList<String>();
    ArrayList<String> number = new ArrayList<String>();
    
    String choice = "", entry = "", option = "y";
    
    //scanner to read in the file
    Scanner scnr = new Scanner(file);
  
    //String that gets the firstline of the file
    String firstLine = scnr.nextLine();
    
    //split the firstline of the file by using comma as a seperator, and 
store it in the array
    //this array will contain the decription of the pokemon
    String[] info = firstLine.split(",");

    System.out.print("Welcome to the Pokedex. ");

    //looping to check if the users wants to search for another Pokemon
    while (option.equalsIgnoreCase("y")) {
      
      //start reading the file again from the top, this will be used if 
the user wants to search for another Pokemon
      scnr = new Scanner(file);
      
      do {
        System.out.println("Would you like to search by name or by 
number?");
        choice = scan.nextLine();
        
        if (choice.equalsIgnoreCase("name") || 
choice.equalsIgnoreCase("number")) {
          System.out.println("Please enter the " + choice + " of the 
Pokemon:");
          entry = scan.nextLine();
        }
      } 
        while (!choice.equalsIgnoreCase("name") &&
          !choice.equalsIgnoreCase("number"));

      //loop until end of file
      while (scnr.hasNextLine()) {
        
        //to store the first line of the file
        String line = scnr.nextLine();
        
        //split the string and store each entry in the array
        String[] entries = line.split(",");
        
        //add each number and name of the pokedox in its respective 
arraylist
        number.add(entries[0]);
        name.add(entries[1]);
      }

      //loop to check if the users entry matches the one in the respective 
arraylist eg; the name specified exists in the name arrayList and prompt 
them to re-enter the name
      while (!name.contains(entry) && !number.contains(entry)) {
        System.out.println(" I'm sorry, but there is no known Pokemon by 
that " + choice + ".");
        System.out.println("Please re-enter the " + choice + " of the 
Pokemon:");
        entry = scan.nextLine();
      }
      
      //re-read the file from the top
      scnr = new Scanner(file);

      while (scnr.hasNextLine()) {
        String data = scnr.nextLine();
        String[] split= data.split(",");

        //check to see whether the first index(number) of the array 
matches the users specified entry
        if (split[0].equalsIgnoreCase(entry)) {
          System.out.println(split[1] + ", Pokedex Number " + split[0] + 
", " + split[2] + ", " + info[3] + ": " + split[3] + ", "
              + info[4] + ": " + split[4]);
        }
        //check to see whether the second index(name) of the array matches 
the users specified entry
        if (split[1].equalsIgnoreCase(entry)) {
          System.out.println(split[1] + ", Pokedex Number " + split[0] + 
", " + split[2] + ", " + info[3] + ": " + split[3] + ", "
              + info[4] + ": " + split[4]);
        }
      }
      
      System.out.println(" Would you like to search for another Pokemon 
(y/n)?");
      option = scan.nextLine();
    }
    System.out.println("Thank you for using your Pokedex!");

    //close file
    scnr.close();
  }
}
