import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
  private boolean animate;
  int xpos = -1;
  int ypos = -1;
  int[][] moves = {{1,0}, {-1,0}, {0,1} , {0,-1}}; //up down left right moves
  int row = 0;
  int col = 0;
  char[][] maze;
  public Maze(String filename)throws FileNotFoundException{
    animate = false;
    try{
      File text = new File(filename);
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
            xpos = countr; //keeping track of where the Start coordinate is
            ypos = i;
            if(xpos == -1 || ypos == -1){
              throw new IllegalStateException();
            }
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
    return solveH(xpos, ypos, 0);
  }

  public int solveH(int row, int col, int steps){
    if(maze[row][col] == 'E'){ //base case or when the recursion stops
      return steps;
    }
    if(maze[row][col] != '#' && maze[row][col] != '.' && maze[row][col] != '@'){ //cannot go to a spot with non white spaces
      maze[row][col] = '@';
      for(int i = 0; i < moves.length; i++){
        int num = solveH(row + moves[i][0], col + moves[i][1], steps + 1);
          if(num != -1){
            return num; //if the code isn't false return the num
          }
      }
      maze[row][col] = '.'; //if there are no possible moves with the array of moves then it marks it with a .
    }
    if(animate){
          clearTerminal();
          System.out.println(this);
          wait(90); //slow enought to see the path of the code
      }
    return -1; //when the code is false
  }

  /*public static void main(String[] args){
    try{
      Maze test = new Maze("data3.dat");
      test.setAnimate(true);
      System.out.println(test.solve());
      System.out.println(test);
    }
    catch(Exception e){
      System.out.println(e);
    }
  }*/
}
