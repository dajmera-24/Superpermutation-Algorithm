public class SuperpermAlgoPrint {

   private int n;
   private int intersect;
   private StringBuilder bead;
   private PrintWriter writer;

   public SuperpermAlgoPrint(char[] c) {
      n = c.length;
      bead = new StringBuilder();
      try {writer = new PrintWriter("superperm_n" + n + ".txt");} 
      catch (IOException e) {e.printStackTrace();}
      startBead(c);
      algo(2);
      writer.close();
   }

   public void startBead(char[] c) {
      for (int i = 0; i < n; i++) {
         bead.append(c[i]);
      }
      for (int i = 0; i < bead.length(); i++) {
         writer.print(bead.charAt(i));
      }
      for (int i = 0; i < bead.length()-1; i++) {
         writer.print(bead.charAt(i));
      }
   }
   
   public void algo(int d) {
      if (d==n) {return;}
      for (int i = 0; i < d; i++) {
         algo(d+1);
         intersect = d-1;
         if (i == d-1) {return;}
         mirrorShift(d);
      }
   }

   public void mirrorShift(int index) {
      int k = n-index;
      String m = bead.substring(0, k);
      for (int i = 0; i < n-k-1; i++) {
         bead.setCharAt(i, bead.charAt(i+k));
      }
      for (int i = n-k-1; i < n-1; i++) {
         if (m.length() == 0) {break;}
         int l = m.length()-1-(i-(n-k-1));
         if (l < 0) {continue;}
         bead.setCharAt(i, m.charAt(l));
      }
      for (int i = intersect; i < bead.length(); i++) {
         writer.print(bead.charAt(i));
      }
      for (int i = 0; i < bead.length()-1; i++) {
         writer.print(bead.charAt(i));
      }
   }
}