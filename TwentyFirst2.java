/**
 * Created by Saksham on 2016-02-27.
 */
import java.util.*;

public class TwentyFirst2 {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        long N = s.nextLong();
        String ch = s.next();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int x =0; x < ch.length();x++) {
            if (!map.containsKey(ch.charAt(x))) {
                map.put(ch.charAt(x),1);
            }
            else
                map.put(ch.charAt(x),map.get(ch.charAt(x)) + 1);
        }
        int M = s.nextInt();
        for (int x = 0; x< M; x++) {
            int counter  =0;
            long row = s.nextLong();
            char e = s.next().charAt(0);
            int letters = 0;
            long index = ((row*(row-1))/2)%ch.length();
            //System.out.println("INDEX: " + index + " ROW+INDEX: " + (row+index));
            for (int z = 0; z < ch.length()-index && z < row; z++) {
                //  System.out.print(ch[z+index] + " ");
               if (ch.charAt(z+(int)index) == e) {
                   counter++;
               }
                letters++;
            }
            long rem =row - letters;
            //System.out.print("\tLetters Remaining:  " + rem);
            //System.out.print("\tRow: " + row);
            if (map.containsKey(e))
            counter += map.get(e) * (rem/ch.length());
            //System.out.print(" MULTIPLYING: " + (rem/ch.length));
                for (int z = 0; z < (rem) % ch.length(); z++) {
                    //       System.out.print(" " + ch[z]);
                    if (ch.charAt(z) == e) {
                        counter++;
                    }
                }


            System.out.println(" " + counter);

        }
    }
}
