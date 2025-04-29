import java.io.*;
import java.util.Scanner;

public class SuperpermAlgo {

    private final int n;
    private int intersect;
    private StringBuilder bead;
    private PrintWriter writer;

    public SuperpermAlgo(char[] c) {
        n = c.length;
        bead = new StringBuilder();
        try {
            writer = new PrintWriter("superperm_n" + n + ".txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        for (int i = 0; i < bead.length() - 1; i++) {
            writer.print(bead.charAt(i));
        }
    }

    public void algo(int d) {
        if (d >= n) {
            return;
        }
        for (int i = 0; i < d; i++) {
            algo(d + 1);
            intersect = d - 1;
            if (i == d - 1) {
                return;
            }
            mirrorShift(d);
        }
    }

    public void mirrorShift(int index) {
        int k = n - index;
        String m = bead.substring(0, k);
        for (int i = 0; i < n - k - 1; i++) {
            bead.setCharAt(i, bead.charAt(i + k));
        }
        for (int i = n - k - 1; i < n - 1; i++) {
            if (m.isEmpty()) {
                break;
            }
            int l = m.length() - 1 - (i - (n - k - 1));
            if (l < 0) {
                continue;
            }
            bead.setCharAt(i, m.charAt(l));
        }
        for (int i = intersect; i < bead.length(); i++) {
            writer.print(bead.charAt(i));
        }
        for (int i = 0; i < bead.length() - 1; i++) {
            writer.print(bead.charAt(i));
        }
    }

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
        new SuperpermAlgo(c);
        long endTime = System.nanoTime();
        System.out.println("\nExecution Time: " + (endTime - startTime) / 1e6 + " ms");
    }
}
