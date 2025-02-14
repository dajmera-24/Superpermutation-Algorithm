import java.util.*;
import java.io.PrintWriter;
import java.io.IOException;
public class SuperpermAlgoPrint {

   private int n;
   private int intersect;
   private StringBuilder currentP;
   private PrintWriter writer;

   public SuperpermAlgoPrint(char[] c) {
      n = c.length;
      currentP = new StringBuilder();
      try {
         writer = new PrintWriter("superperm_n" + n + ".txt");
      } catch (IOException e) {
         e.printStackTrace();
      }
      startPhrase(c);
      algo(2);
      writer.close();
   }

   public void startPhrase(char[] c) {
      for (int i = 0; i < n; i++) {
         currentP.append(c[i]);
      }
      for (int i = 0; i < currentP.length(); i++) {
         writer.print(currentP.charAt(i));
      }
      for (int i = 0; i < currentP.length()-1; i++) {
         writer.print(currentP.charAt(i));
      }
   }
   
   public void algo(int d) {
      if (d==n) {
         return;}
      for (int i = 0; i < d; i++) {
         algo(d+1);
         intersect = d-1;
         if (i == d-1) {
            return;}
         coinject(d);
      }
   }

   public void coinject(int index) {
      int k = n-index;
      String m = currentP.substring(0, k);
      for (int i = 0; i < n-k-1; i++) {
         currentP.setCharAt(i, currentP.charAt(i+k));
      }
      for (int i = n-k-1; i < n-1; i++) {
         if (m.length() == 0) {
            break;}
         int l = m.length()-1-(i-(n-k-1));
         if (l < 0) {
            continue;}
         currentP.setCharAt(i, m.charAt(l));
      }
      for (int i = intersect; i < currentP.length(); i++) {
         writer.print(currentP.charAt(i));
      }
      for (int i = 0; i < currentP.length()-1; i++) {
         writer.print(currentP.charAt(i));
      }
   }
}