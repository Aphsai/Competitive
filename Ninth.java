/**
 * Created by Saksham on 2016-02-19.
 */
import java.util.*;
import java.io.*;
public class Ninth {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
       TreeSet<Integer> set = new TreeSet<Integer>();
        for (int x = 0; x <= G; x++){
            set.add(x);
        }
        int total = 0;
        boolean in = false;
        outer: for (int x =0 ;x  < P; x++) {
            int gate = Integer.parseInt(br.readLine());
            if (set.floor(gate)== 0) {
                System.out.println(total);
                return;
            }
            total++;
            set.remove(set.floor(gate));

        }
        System.out.println(total);
    }

}
