/**
 * Created by Saksham on 2016-02-19.
 */
import java.util.*;
public class Tenth {

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        for (int x =0; x < N; x++) {
            set.add(s.nextInt());
        }
        for (int x = 0; x< N; x++) {
            System.out.println(set.pollFirst());
        }
    }
}
