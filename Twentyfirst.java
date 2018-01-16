/**
 * Created by Saksham on 2016-02-27.
 */
import java.util.*;

public class Twentyfirst {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        long N = s.nextLong();
        char [] ch = s.next().toCharArray();
        int M = s.nextInt();
        for (int x = 0; x< M; x++) {
            int counter  =0;
            int row = s.nextInt();
            char e = s.next().charAt(0);
                int y = row-1;
                int index = ((row*(row-1))/2%ch.length);
                for (int z = index; z < row+index; z++) {
                    if (z >= ch.length) {
                        if (ch[z%ch.length] == e){
                            counter++;
                        }
                    }
                    else {
                        if (ch[z] == e) {
                            counter++;
                        }
                    }
                }

            System.out.println(counter);

        }
    }
}
