/**
 * Created by Saksham on 2016-03-05.
 */
import java.util.*;
public class ThirtyFifth {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        while(true) {
            String token = s.next();
            if (token.equals("X")) {
                break;
            }
            String[] word = token.split("A");
            for (int x = 0; x < word.length; x++) {
                System.out.print(word[x] + " ");
            }
            System.out.println();

        }
    }
}
