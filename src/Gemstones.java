import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// problem link  https://www.hackerrank.com/challenges/gem-stones/problem
public class Gemstones {

    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        int matchCounter = 0;
        boolean allDone = true;
        int[][] domain = new int[arr.length][26];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                domain[i][arr[i].charAt(j) - 97] = 1;
            }
        }

        for (int i = 0; i < 26; i++) {
            allDone = true;
            for (int j = 0; j < arr.length; j++) {
                if (domain[j][i] != 1)
                    allDone = false;
            }
            if (allDone)
                matchCounter++;
        }
        return matchCounter;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);
        System.out.println(result);

        scanner.close();
    }
}
