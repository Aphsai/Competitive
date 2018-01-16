/**
 * Created by Saksham on 2016-02-19.
 */
import java.util.*;
public class Eleventh {
    static boolean palindrome(String str) {
        for (int x =0; x< str.length()/2; x++) {
            if (str.charAt(x) != str.charAt(str.length()-1-x)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long N = s.nextInt();
        for (int x = 2; x <= N; x++){
            if (Eleventh.palindrome(Long.toString(N,x))) {
                System.out.println(x);
            }
        }

    }
}
