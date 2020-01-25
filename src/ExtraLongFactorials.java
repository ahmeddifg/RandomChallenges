//Complete the extraLongFactorials function in the editor below. It should print the result and return.
//
//        extraLongFactorials has the following parameter(s):
//
//        n: an integer
//        Sample Input
//        25
//        Sample Output
//        15511210043330985984000000
import java.math.*;
import java.util.*;
public class ExtraLongFactorials {
    // Complete the extraLongFactorials function below.

    static void extraLongFactorials(int n) {
        BigInteger number =new BigInteger("1");

        for(int i=1; i<= n ;i++){
            number = number.multiply(new BigInteger(i+""));
        }
        System.out.println(number.toString());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
