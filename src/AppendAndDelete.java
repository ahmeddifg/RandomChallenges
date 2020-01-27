import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AppendAndDelete {
    // Problem link https://www.hackerrank.com/challenges/append-and-delete/problem
    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        String match = "";
        int diffCount=0;
        if (s.equals(t))
            return "Yes";
        else if (Math.abs(t.length() - s.length()) > k)
            return "No";

        if (s.length() > t.length()){
            diffCount=s.length()-t.length();
            s = s.substring(0, t.length());
        }

        for (int i = s.length(); i >= 0; i--) {
            if (s.substring(0, i).equals(t.substring(0,i))) {
                match = s.substring(0, i);
                break;
            }
        }
        diffCount += s.length()-match.length()+ t.length()-match.length();
        if (Math.abs(diffCount) <= k)
            return "Yes";
        else return "No";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);
        System.out.println(result);

        scanner.close();
    }
}
