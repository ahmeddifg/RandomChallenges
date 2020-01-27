import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Problem link https://www.hackerrank.com/challenges/permutation-equation/problem
public class SequenceEquation {

    // Complete the permutationEquation function below.
    static int[] permutationEquation(int[] p) {
        int[] returnArray = new int[p.length];
        for (int i = 1; i <= p.length; i++) {
            returnArray[i-1] =returnXIndex(p,returnXIndex(p,i));    ;
        }
        return returnArray;
    }
    static int returnXIndex(int[] p,int x){
        for(int i=0;i<p.length;i++){
            if(p[i]==x)
                return i+1;
        }
        return -1;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] p = new int[n];

//        String[] pItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int pItem = Integer.parseInt(pItems[i]);
//            p[i] = pItem;
//        }

        int[] result = permutationEquation(new int[]{5,2,1,3,4});
        Arrays.stream(result).forEach(System.out::println);
        scanner.close();
    }
}
