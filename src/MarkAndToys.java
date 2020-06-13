import java.io.*;
import java.util.*;

// Problem link https://www.hackerrank.com/challenges/mark-and-toys/problem
/*
*  Complete the function maximumToys in the editor below.
*  It should return an integer representing the maximum number of toys Mark can purchase.
maximumToys has the following parameter(s):
    prices: an array of integers representing toy prices
    k: an integer, Mark's budget
 */
public class MarkAndToys {

    static int maximumToys(int[] prices, int k) {
        int spend = 0;
        int counter=0;
        prices = Arrays.stream(prices).map(e -> e - k).toArray();
        prices = Arrays.stream(prices).filter(e -> e <= 0).toArray();
        prices = Arrays.stream(prices).map(e -> e + k).toArray();
        Arrays.sort(prices);
        for (int p : prices) {
            spend += p;
            ++counter;
            if (spend > k) {
                --counter;
                spend = spend - p;
                break;
            }
        }
        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] prices = new int[n];
        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);
        System.out.println(result);

        scanner.close();
    }
}
