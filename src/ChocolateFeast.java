import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Problem link https://www.hackerrank.com/challenges/chocolate-feast/problem
public class ChocolateFeast {

    // Complete the chocolateFeast function below.
    static int chocolateFeast(int n, int c, int m) {
        int counter = 0;
        int wrappers = 0;
        int reminder = 0;
        counter = n / c;
        wrappers = counter;
        if (n >= c) {
            while (wrappers >= m) {
                counter += wrappers / m;
                reminder = wrappers % m;
                wrappers = reminder + wrappers / m;
            }
            return counter;
        } else return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] ncm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(ncm[0]);

            int c = Integer.parseInt(ncm[1]);

            int m = Integer.parseInt(ncm[2]);

            int result = chocolateFeast(n, c, m);
            System.out.println(result);
        }
        scanner.close();
    }
}
