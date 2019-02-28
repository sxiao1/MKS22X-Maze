import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
  int xpos = 0;
  int ypos = 0;
  int[] xmoves = {1,-1};
  int[] ymoves = {1, -1};
  int row = 0;
  int col = 0;
  char[][] maze = new char[row][col];
  public String toString(){
    String newstr= "";
    for (int i = 0; i < maze.length; i++) {
      newstr+=maze[i];
    }
    return newstr;
  }

  public void readFile() throws FileNotFoundException{
    File text = new File("Maze1.txt");
    Scanner in = new Scanner(text);
    while(in.hasNextLine()){
      String newstr = in.nextLine();
      col = newstr.length();
      row ++;
    }
    in = new Scanner(text);
    int countr = 0;
    while(in.hasNextLine()){
      String line = in.nextLine();
      for(int i = 0; i < line.length(); i++){
        maze[countr][i] = line.charAt(i);
        if(maze[countr][i] =='S'){
          xpos = countr;
          ypos = i;
        }
      }
      countr ++;
    }
  }

  public int solve(){
    maze[xpos][ypos] = '@';
    if(xpos + xmoves[0] < row && maze[xpos + xmoves[0]][ypos] != '@'){
      maze[xpos + xmoves[0]][ypos] = '@';
    }
    else if(xpos + xmoves[1] < row && maze[xpos + xmoves[0]][ypos] != '@'){
      maze[xpos + xmoves[1]][ypos] = '@';
    }
    else if(ypos + ymoves[0] < col && maze[xpos][ypos + ymoves[0]] != '@'){
      maze[xpos][ypos + ymoves[0]]= '@';
    }
    else if(ypos + ymoves[1] < col && maze[xpos][ypos + ymoves[1]] != '@'){
      maze[xpos][ypos + ymoves[1]] = '@';
    }
    return 1;
  }



}
