package section1;

import java.io.PrintWriter;
import java.util.Scanner;

public class ErasingMaximum {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n;
        n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        int[] result = eraseMaximum(a);

        for (int i = 0; i < result.length; ++i) {
            if (i != 0) out.print(' ');
            out.print(result[i]);
        }
        out.println();

        in.close();
        out.close();
    }

    static int[] eraseMaximum(int[] a) {
        int[] result = new int[a.length - 1];
        int max = Integer.MIN_VALUE;
        int maxCount = 0;
        int idxToDelete = -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                maxCount = 1;
                idxToDelete = i;
            } else if (a[i] == max) {
                maxCount++;
                if (maxCount == 3)
                    idxToDelete = i;
            }
        }

        System.arraycopy(a, 0, result, 0, idxToDelete);
        System.arraycopy(a, idxToDelete + 1, result, idxToDelete, a.length - idxToDelete - 1);
        return result;
    }
}