import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Problem link https://www.hackerrank.com/challenges/recursive-digit-sum/problem
public class RecursiveDigitSum {

    // Complete the superDigit function below.
    static int superDigit(String n, int k) {
        BigInteger sum = new BigInteger("0");
        if (n.length() == 1)
            return Integer.parseInt(n);
        else {
            for (int i = 0; i < n.length(); i++) {
                sum=sum.add(new BigInteger(Integer.parseInt( n.charAt(i) + "")+""));
            }
            if (k > 0)
                sum = sum.multiply(new BigInteger(k+""));
            return superDigit(sum + "", 0);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        System.out.println(result);

        scanner.close();
    }
}
