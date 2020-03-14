import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


// Problem link  https://www.hackerrank.com/challenges/big-sorting/problem

public class BigSorting {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {
        unsorted = Arrays.stream(unsorted).sorted(
                (s1, s2) -> {
                    if (s1.length() > s2.length())
                        return 1;
                    else if (s2.length() > s1.length())
                        return -1;
                    else {
                        BigInteger n1 = new BigInteger(s1);
                        BigInteger n2 = new BigInteger(s2);
                        return n1.compareTo(n2);
                    }
                }
        ).toArray(String[]::new);
        return unsorted;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(scanner.nextLine());
        String[] unsorted = new String[n];
        for (int i = 0; i < n; i++) {
            String unsortedItem = scanner.nextLine();
            unsorted[i] = unsortedItem;
        }

        String[] result = bigSorting(unsorted);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        scanner.close();
    }
}
