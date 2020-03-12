import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Problem link https://www.hackerrank.com/challenges/alternating-characters/problem

public class AlternatingCharacters {

    // Complete the alternatingCharacters function below.
        static int alternatingCharacters(String s) {
            int counter = 0;
            for (int i = 0; i < s.length(); i++) {
                if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1))
                    counter++;
            }
            return counter;
        }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            System.out.println(result);
        }

        scanner.close();
    }
}
