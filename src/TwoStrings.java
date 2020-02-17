import java.io.*;
import java.util.*;

// Problem link https://www.hackerrank.com/challenges/two-strings/problem
public class TwoStrings {
    static String twoStrings(String s1, String s2) {
        int[] domain = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            domain[s1.charAt(i) - 97]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            if(domain[s2.charAt(i)-97]>0)
                return "YES";
        }

       return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);
            System.out.println(result);
        }
        scanner.close();
    }
}
