import java.io.*;
import java.util.*;
// Problem link //https://www.hackerrank.com/challenges/encryption/problem
public class Encryption {

    // Complete the encryption function below.
    static String encryption(String s) {
        StringBuilder stringBuilder = new StringBuilder("");
        s = s.replace(" ", "");
        int end, part, col, currentIndex = 0;
        end = (int) Math.ceil(Math.sqrt(s.length()));
        col = (int) Math.ceil(Math.sqrt(s.length()));
        part = end;
        StringBuilder output = new StringBuilder();
        while (end <= s.length()) {
            stringBuilder.append(s.substring(currentIndex, end) + "\n");
            currentIndex = end;
            if (end + part < s.length())
                end += part;
            else {
                end = s.length();
                stringBuilder.append(s.substring(currentIndex, end) + "\n");
                break;
            }
        }
        String[] dataSet = stringBuilder.toString().split("\n");
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < dataSet.length; i++) {
                if(j<dataSet[i].length())
                    output.append(dataSet[i].charAt(j));
            }
            output.append(" ");
        }
        return output.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        String result = encryption(s);
        System.out.println(result);

        scanner.close();
    }
}
