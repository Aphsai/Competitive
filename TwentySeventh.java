/**
 * Created by Saksham on 2016-03-01.
 */
import java.util.*;
public class TwentySeventh {
    public static void main(String [] args) {
        Scanner s = new Scanner(System.in);
        long Ei = s.nextLong();
        long Ef = s.nextLong();
        long Eb = s.nextLong();
        int  B = s.nextInt();
        int  C = s.nextInt();
        long  mod = Eb%B;
        long  curr = Ei;
        long  fish = 0;
        while(true) {
            if (curr < Ef) {
                if (Eb > B) {
                    Eb -= B;
                    curr += 3 * B;

                } else if (Eb == mod) {
                    Eb = 0;
                    curr += 2 * B + mod;
                }
                else
                    curr += 2*B;
                fish++;
            }
            else
                break;
        }
        System.out.println(fish);
        System.out.println(fish*C);
    }
}
