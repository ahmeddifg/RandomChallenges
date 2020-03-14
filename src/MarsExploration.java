import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Problem link https://www.hackerrank.com/challenges/mars-exploration/problem

public class MarsExploration {

    // Complete the marsExploration function below.
    static int marsExploration(String s) {
        int difference = 0;
        String sosString = "SOS";
        for (int i = 0; i < s.length(); i++) {
             if(s.charAt(i) != sosString.charAt(i%3))
                ++difference;
        }
        return difference;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        int result = marsExploration(s);
        System.out.println(result);
        scanner.close();
    }
}
