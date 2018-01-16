/**
 * Created by Saksham on 2016-03-02.
 */
import java.util.*;
public class Thirtieth {
    public static void main(String[] args) {
        TreeSet<Long> set = new TreeSet<>();
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        double total = 0;
        for (int x = 0; x < N; x++) {
            long T = s.nextLong();
            set.add(T);
//            System.out.println(set);
            total += set.tailSet(T).size();
        }
        System.out.printf("%.2f\n",total/set.size());
    }
}
