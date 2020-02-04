
import java.util.*;
// Problem link   https://www.hackerrank.com/challenges/mini-max-sum/problem
public class MiniMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(long[] arr) {
        long temp = 0;
        long sumMin = 0;
        long sumMax = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        sumMin = Arrays.stream(arr).sum() - arr[arr.length - 1];
        sumMax = Arrays.stream(arr).sum() - arr[0];
        System.out.println(sumMin + " " + sumMax);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long[] arr = new long[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
