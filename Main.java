
/**
 * Benis Munezero
 * COSC 237 Sec 001
 * Lab 3 Task 2, Array
 */

import java.util.Scanner;
import java.util.Random;
public class Main {
  public static final int MIN = 0;
  public static final int MAX = 2; 
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    boolean startContinue = getChar(sc, "Start (y/n): ");    
    while (startContinue) {
       //int line = 0;
       int rows = getInt(sc, "How many rows: ");
       int columns = getInt(sc, "How many columns: ");
       int[][] matrix = new int[rows][columns];
       initRand (matrix, MIN, MAX);
       System.out.println("\nThe Matrix is:"); 
       print2DimArray(matrix);

         System.out.println();      
       isFlipped(matrix);
       startContinue = getChar(sc, "Continue (y/n): ");
    } 
    System.out.println("Have a nice day:)");
  }

  public static int getInt(Scanner in, String prompt) {
    System.out.print(prompt);
    while (!in.hasNextInt()) {
      in.next();
      System.out.println("Error! Not a valid intenger.\nPlease input a valid intenger!");
    }
    return in.nextInt();
  }

  public static void print2DimArray(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print("[" + i + "]  ");
      for (int j = 0; j < arr[i].length; j++) {
        System.out.printf("%d ", arr[i][j]);
      }
      System.out.println();
    }
  }
  public static boolean getChar(Scanner in, String prompt) {
    boolean isValid;
    String s;
    do {
      System.out.print(prompt);
      s = in.next();
      isValid = (s.equalsIgnoreCase("y") || s.equalsIgnoreCase("n"));
      if (!isValid) {
        System.out.println("Error! Entry must be 'y' or 'n'. Try again.");
      }
      } while (!isValid);
         return s.equalsIgnoreCase("y");  
  
  }
  public static void initRand(int[][] nums, int low, int up) {
    Random rand = new Random();
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums[i].length; j++) {
        nums[i][j] = rand.nextInt(up - low) + low;
      }
    }
    
  }

  
  public static void isFlipped(int[][] matrix) {
    boolean flipped = false;
      for (int i = 0; i < matrix.length - 1; i++) {
        for (int j = i + 1; j < matrix.length; j++) {
          boolean isFlipped = true;
          for (int k = 0; k < matrix[i].length; k++) {
            if (matrix[i][k] == matrix[j][k]) {
              isFlipped = false;
              break;
            }
          }
          if (isFlipped) {
            System.out.printf("Rows index %d and %d are flipped.\n", i, j);
            flipped = true;
          }
        }     
      }
        if (!flipped) {
          System.out.println("No rows are flipped.");
      }
  }
   

}

