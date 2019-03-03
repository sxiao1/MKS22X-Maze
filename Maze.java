import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
  private boolean animate;
  int xpos = 0;
  int ypos = 0;
  int[][] moves = {{1,0}, {-1,0}, {0,1} , {0,-1}};
  int row = 0;
  int col = 0;
  char[][] maze;
  public Maze(String filename)throws FileNotFoundException{
    animate = false;
    try{
      File text = new File("data1.dat");
      Scanner in = new Scanner(text);
      while(in.hasNextLine()){
        String newstr = in.nextLine();
        col = newstr.length();
        row ++;
      }
      maze = new char[row][col];
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
    catch(FileNotFoundException e){}
  }
  public void setAnimate(boolean b){
    animate = b;
  }
  public void wait(int millis){
    try {
     Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }

   public void clearTerminal(){
       System.out.println("\033[2J\033[1;1H");
   }
  public String toString(){
    String newstr= "";
    for (int i = 0; i < maze.length; i++) {
      for(int x = 0; x < maze[0].length; x++){
        newstr+=maze[i][x];
      }
      newstr += "\n";
    }
    return newstr;
  }

  /*public void readFile() throws FileNotFoundException{
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
  }*/

  public boolean check(int row, int col){
    if(maze[row][col] != ' ' || maze[row][col] != 'E'){
      return false;
    }
    return true;
  }

  public int solve(){
    return (solveH(xpos, ypos, 0));
  }

  public int solveH(int row, int col, int steps){
    if(maze[row][col] == 'E'){
      return steps;
    }
    for(int i = 0; i < moves.length; i++){
      int rowCheck = row + moves[i][0];
      int colCheck = col + moves[i][0];
      if(maze[rowCheck][colCheck] == ' ' || maze[rowCheck][colCheck] == 'E'){
        maze[row][col] = '@';
        int result = solveH(rowCheck, colCheck, steps + 1);
        if(result != -1){
          return result;
        }
        //maze[row][col] = '.';
      }
    }
    return -1;
  }

  public static void main(String[] args){
    try{
      Maze test = new Maze("data1.dat");
      test.setAnimate(true);
      System.out.println(test.solve());
      System.out.println(test);
    }
    catch(Exception e){
      System.out.println(e);
    }
    }
}
