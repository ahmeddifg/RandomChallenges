import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Problem link https://www.hackerrank.com/challenges/game-of-thrones/problem
public class GameOfThronesI {

    static String gameOfThrones(String s) {
        int odd = 0;
        int even = 0;
        int[] domain = new int[26];
        for (int i = 0; i < s.length(); i++) {
            domain[s.charAt(i) - 97]++;
        }
        for (int i = 0; i < domain.length; i++) {
            if (domain[i] != 0 && domain[i] % 2 == 0) {
                even++;
            }
            if (domain[i] != 0 && domain[i] % 2 != 0) {
                odd++;
            }
        }
        if (odd == 1 && even != 0)
            return "YES";
        else if (odd == 0 && even != 0)
            return "YES";
        else return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        String result = gameOfThrones(s);
        System.out.println(result);

        scanner.close();
    }
}
