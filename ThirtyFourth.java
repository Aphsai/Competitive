/**
 * Created by Saksham on 2016-03-05.
 */
import java.util.*;
public class ThirtyFourth {
    public static void main(String[] args) {
    Scanner s= new Scanner(System.in);
        int N = s.nextInt();
        for (int y = 0; y < N; y++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int counter = b-a;
            for (int x =a; x < b; x++) {
                if (x != 2 && x!=3 && x!=5 && x!= 7) {
                    if (x%2 == 0) {
                        counter--;
                        continue;
                    }
                    if (x%3 == 0) {
                        counter--;
                        continue;
                    }
                    if (x%5 == 0) {
                        counter--;
                        continue;
                    }
                    if (x%7 == 0) {
                        counter--;
                        continue;
                    }
                }
                System.out.println(x-1);
            }
            System.out.println(counter);
        }
    }

}
