import java.io.*;
import java.util.*;

// Problem link https://www.hackerrank.com/challenges/mark-and-toys/problem
/*
*  Complete the function maximumToys in the editor below.
*  It should return an integer representing the maximum number of toys Mark can purchase.
maximumToys has the following parameter(s):
    prices: an array of integers representing toy prices
    k: an integer, Mark's budget
 */
public class MarkAndToys {
    static int[] acmTeam(String[] topic) {
        int max = 0;
        Map<String, Integer> pairs = new HashMap<String, Integer>();
        String tempValue = null;
        int maxCounter = 0;
        int oneBitsCount = 0;
        for (int i = 0; i < topic.length - 1; i++) {
            for (int j = i + 1; j < topic.length; j++) {
                oneBitsCount = mergeItems(topic[i], topic[j]);
                if (oneBitsCount >= max) {
                    pairs.put("(" + (i + 1) + "," + (j + 1) + ")", oneBitsCount);
                    if (max < pairs.get("(" + (i + 1) + "," + (j + 1) + ")"))
                        max = pairs.get("(" + (i + 1) + "," + (j + 1) + ")");
                }
            }
        }

        for (Map.Entry<String, Integer> entry : pairs.entrySet()) {
            if (entry.getValue() == max)
                ++maxCounter;
        }
        return new int[]{max, maxCounter};
    }

    static int mergeItems(String item1, String item2) {
        int counter = 0;
        for (int i = 0; i < item1.length(); i++) {
            if ((Integer.parseInt(item1.charAt(i) + "") | Integer.parseInt(item2.charAt(i) + "")) == 1)
                ++counter;
        }
        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
