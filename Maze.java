import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
  public static void main(String args[]){
    System.out.println(returnString(1));
  }
  public static String returnString(int n){
    String newstr = "";
    try{
      File text = new File("Maze1.txt");
      Scanner scanText = new Scanner(text);
      while (scanText.hasNextLine()){
        newstr += scanText.nextLine() + "\n";
      }
    }
    catch(Exception e){
      newstr += "FileNotFoundException";
    }
    return newstr;
  }

  public static String arrayChar(String someStr){
    String newstr = "";
    int [][] newArr = new int[10][10];
    try{
      File text = new File("Maze1.txt");
      Scanner scanText = new Scanner(text);
      while (scanText.hasNextLine()){
        newstr += scanText.nextLine() + "\n";
      }
    }
    catch(Exception e){
      newstr += "FileNotFoundException";
    }
    return newstr;
  }

}
