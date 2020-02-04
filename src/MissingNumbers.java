import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MissingNumbers {

    // Complete the missingNumbers function below.
    static Integer[] missingNumbers(int[] arr, int[] brr) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }

        for (int j = 0; j < brr.length; j++) {
            if (map.get(brr[j]) == null) {
                if (!integers.contains(brr[j]))
                    integers.add(brr[j]);
            } else {
                map.put(brr[j], map.get(brr[j]) - 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                if (!integers.contains(entry.getKey()))
                    integers.add(entry.getKey());
                System.out.println();
            }
        }

        return integers.stream().sorted().toArray(Integer[]::new);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] brr = new int[m];

        String[] brrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrItems[i]);
            brr[i] = brrItem;
        }

        Integer[] result = missingNumbers(arr, brr);
        Arrays.stream(result).forEach(System.out::print);
        scanner.close();
    }
}
