import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.IntStream;

public class ServiceLane {

    // Complete the serviceLane function below.
    static int[] widths;

    static int[] serviceLane(int n, int[][] cases) {
        int[] result = new int[cases.length];
        int[] temp = null;
        int min=-1;
        for (int i = 0; i < cases.length; i++) {
            min=-1;
            for(int j=cases[i][0]; j<=cases[i][1];j++){
                if(min>widths[j]|| min==-1)
                    min=widths[j];
            }
            result[i]=min;
        }
    return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nt = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nt[0]);

        int t = Integer.parseInt(nt[1]);

        int[] width = new int[n];

        String[] widthItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int widthItem = Integer.parseInt(widthItems[i]);
            width[i] = widthItem;
        }
        widths = width;
        int[][] cases = new int[t][2];

        for (int i = 0; i < t; i++) {
            String[] casesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int casesItem = Integer.parseInt(casesRowItems[j]);
                cases[i][j] = casesItem;
            }
        }

        int[] result = serviceLane(n, cases);
        Arrays.stream(result).forEach(System.out::println);

        scanner.close();
    }
}
