package section1;

import java.io.PrintWriter;
import java.util.Scanner;

public class AdditionAndSubtraction {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int x, y, z;
        x = in.nextInt();
        y = in.nextInt();
        z = in.nextInt();

        int result = result(x, y, z);

        out.println(result);

        in.close();
        out.close();
    }

    static int result(int x, int y, int z) {
        for (int a = 0, i = 1; i < Integer.MAX_VALUE; i++) {
            if ((a & 1) == 1)
                a += x;
            else
                a -= y;

            if (a == z)
                return i;
        }
        return -1;
    }
}