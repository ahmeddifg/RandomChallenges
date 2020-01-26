// Problem link https://www.hackerrank.com/challenges/cut-the-sticks/problem

    /*
     Complete the cutTheSticks function in the editor below.
     It should return an array of integers representing the number of sticks before each cut operation is performed.
     cutTheSticks has the following parameter(s):
     arr: an array of integers representing the length of each stick put Format The first line contains a single integer , the size of .
     The next line contains space-separated integers, each an where each value represents the length of the stick.
     Output Format
     For each operation, print the number of sticks that are present before the operation on separate lines. */

import java.io.*;
import java.util.*;

public class CutTheSticks {

    // Complete the cutTheSticks function below.
    static Integer[] cutTheSticks(int[] arr) {
        ArrayList<Integer> returnArr = new ArrayList<>();
        int min = 0;
        while (arr.length > 0) {
            arr = Arrays.stream(arr).filter(value -> value > 0).toArray();
            if(Arrays.stream(arr).min().isPresent())
                min = Arrays.stream(arr).min().getAsInt();
            for (int i = 0; i < arr.length; i++)
                arr[i] = arr[i] - min;

            if(arr.length>0)
                returnArr.add(arr.length);
        }
        return returnArr.stream().toArray(Integer[]::new);

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

        Integer[] result = cutTheSticks(arr);
        Arrays.stream(result).forEach(System.out::println);

        scanner.close();
    }
}
