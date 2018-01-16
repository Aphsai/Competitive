/**
 * Created by Saksham on 2016-03-01.
 */
import java.util.*;
public class TwentyEighth {
    public static void main(String [] args) {
        Scanner s = new Scanner(System.in);
        double tests = 0;
        int N = s.nextInt();
        for (int x = 0; x < N; x++) {
            tests += s.nextDouble()%360;
        }
        System.out.printf("%.5f\n",tests%360);
    }

}
