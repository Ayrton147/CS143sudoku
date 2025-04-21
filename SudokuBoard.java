import java.util.*;
import java.io.*;

public class SudokuBoard {
   private char[][] board;
   
   public SudokuBoard(String fileName) {
      board = new char[9][9];
      load(fileName);
   }
   
   public void load(String fileName) {
      try {
         Scanner file = new Scanner(new File(fileName));
         
        int r = 0;

        while (file.hasNextLine() && r < 9) {
            String line = file.nextLine();
            for (int c = 0; c < 9 && c < line.length(); c++) {
                board[r][c] = line.charAt(c);
            }
            r++;
        }
         
      } catch(FileNotFoundException e) {
         System.out.println("Cannot load: " + fileName);
      } catch(InputMismatchException e) {
         System.out.println(fileName + " does not meet format expectations.");
      }
   }
   
   
   public String toString() {
      String build = "";
      for(int r = 0; r < board.length; r++) {
         build += "|\t";
         for(int c = 0; c < board[0].length; c++) {
            char cell = board[r][c];
            String spot = cell == '.' ? "-" : ""+ board[r][c];
            build += spot + "\t";
         }
         build += "|\n";
      }
      return build;
   }
}

/*
# PROGRAM OUTPUT

 |	2	-	-	1	-	5	-	-	3	|
 |	-	5	4	-	-	-	7	1	-	|
 |	-	1	-	2	-	3	-	8	-	|
 |	6	-	2	8	-	7	3	-	4	|
 |	-	-	-	-	-	-	-	-	-	|
 |	1	-	5	3	-	9	8	-	6	|
 |	-	2	-	7	-	1	-	6	-	|
 |	-	8	1	-	-	-	2	4	-	|
 |	7	-	-	4	-	2	-	-	1	|

*/
