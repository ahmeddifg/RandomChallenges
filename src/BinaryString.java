import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// problem link https://www.hackerrank.com/challenges/beautiful-binary-string/

public class BinaryString {

    // Complete the beautifulBinaryString function below.
    static int beautifulBinaryString(String b) {
        int replaceCount = 0;
        int found = 0;
        while (found >= 0 && found<b.length()) {
            found = b.indexOf("010", found);
            if(found>=0 && found<b.length()) {
                found+=3;
                replaceCount++;
            }
        }
        return replaceCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
        String b = scanner.next();
        int result = beautifulBinaryString(b);
        System.out.println(result);

    }
}
