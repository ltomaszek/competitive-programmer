package section1;

import java.util.Scanner;

public class Increment {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        int res = 0;

        if (inp.matches("[9]+"))
            res = inp.length() + 1;
        else
            res = inp.length();

        System.out.println(res);

        sc.close();
    }

}