import java.util.*;
public class Runner {

   public static char[] arrHelper(int n) {
      char[] c = new char[n];
      for (int i = 0; i < n; i++) {
         c[i] = (char) ('0' + (i + 1));
      }
      return c;
   }

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter the number of symbols in integer format:");
      int n = input.nextInt();
      char[] c = arrHelper(n);
      long startTime = System.nanoTime();
      SuperpermAlgoPrint s = new SuperpermAlgoPrint(c);
      long endTime = System.nanoTime();
      System.out.println("\nExecution Time: " + (endTime - startTime) / 1e6 + " ms");
   }
}