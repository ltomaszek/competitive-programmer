package section2;
import java.util.Scanner;

public class SumOfMinimum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        System.out.println(calculateMinSumOnSubsets(a));
    }

    public static long calculateMinSumOnSubsets(int[] arr){
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                sum += min;
            }
        }
        return sum;
    }
}
