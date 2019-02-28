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

  public boolean check(int row, int col){
    if(maze[row][col] != ' ' || maze[row][col] != 'E'){
      return false;
    }
    return true;
  }

  public int solve(){
    maze[xpos][ypos] = '@';
    return -1;
  }

  public int solveH(int row, int col){
    if(maze[row][col] == 'E'){
      return -1;
    }
    if(check(row, col)){
      maze[row][col] = '@';
      if(row + xmoves[0] < maze.length && row + xmoves[0] >= 0){
        return solveH(row + xmoves[0], col);
      }
      if(row + xmoves[1] < maze.length && row + xmoves[1] >= 0){
        return solveH(row + xmoves[1], col);
      }
      if(col + ymoves[0] < maze[0].length && col + ymoves[0] >= 0){
        return solveH(row,col + ymoves[0]);
      }
      if(col + ymoves[1] < maze[0].length && col + ymoves[1] >=0){
        return solveH(row, col + ymoves[1]);
      }
    }
    return 1;
  }

  public void retrack(int row, int col){
  }
}
