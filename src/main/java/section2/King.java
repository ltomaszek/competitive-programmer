package section2;

import java.io.PrintWriter;
import java.util.Scanner;

public class King {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int r, c;
        r = in.nextInt();
        c = in.nextInt();

        int result = maxKings(r, c);

        out.println(result);

        in.close();
        out.close();
    }

    public static int maxKings(int numRows, int numColumns) {
        int result = 0;
        int fRow = numRows / 3;
        int fCol = numColumns / 3;
        int modR = numRows % 3;
        int modC = numColumns % 3;
        result += fRow * fCol * 8;
        if (modR > 0)
            result += modR * fCol * 3 - fCol;
        if (modC > 0)
            result += modC * fRow * 3 - fRow;
        if (modR > 0 && modC > 0)
            result += modR * modC - 1;
        return  result;
    }
}