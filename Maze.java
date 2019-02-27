import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
  public static void main(String args[])throws FileNotFoundException{
    File text = new File("Maze1.txt");
    Scanner in = new Scanner(text);
    int row = 0;
    int col = 0;
    while(in.hasNextLine()){
      String newstr = in.nextLine();
      col = newstr.length();
      row ++;
    }
    in = new Scanner(text);
    char[][] maze = new char[row][col];
    int countr = 0;
    while(in.hasNextLine()){
      String line = in.nextLine();
      for(int i = 0; i < line.length(); i++){
        maze[countr][i] = line.charAt(i);
      }
      countr ++;
    }
    for (int i = 0; i < maze.length; i++) {
      System.out.println(maze[i]);
    }

  }

}
