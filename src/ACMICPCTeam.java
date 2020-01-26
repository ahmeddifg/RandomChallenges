import java.io.*;
import java.util.*;

//problem link https://www.hackerrank.com/challenges/acm-icpc-team/problem

//        There are a number of people who will be attending ACM-ICPC World Finals. Each of
//        them may be well versed in a number of topics. Given a list of topics known by each attendee,
//        you must determine the maximum number of topics a 2-person team can know. Also find out how many ways
//        a team can be formed to know that many topics. Lists will be in the form of
//        bit strings, where each string represents an attendee and each position in that string represents
//        a field of knowledge, 1 if its a known field or 0 if not.
public class ACMICPCTeam {

    static int[] acmTeam(String[] topic) {
        int max = 0;
        Map<String, Integer> pairs = new HashMap<String, Integer>();
        int maxCounter = 0;
        int oneBitsCount = 0;
        for (int i = 0; i < topic.length - 1; i++) {
            for (int j = i + 1; j < topic.length; j++) {
                oneBitsCount = mergeItems(topic[i], topic[j]);
                if ( oneBitsCount >= max) {
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
        int counter=0;
        for (int i = 0; i < item1.length(); i++) {
            if (( Integer.parseInt(item1.charAt(i)+"") |  Integer.parseInt(item2.charAt(i)+"")   )==1 )
                ++counter;
        }
        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);
        Arrays.stream(result).forEach(System.out::println);

        scanner.close();
    }
}
