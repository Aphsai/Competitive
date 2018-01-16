/**
 * Created by Saksham on 2016-03-14.
 */
import java.util.*;
public class Fifty3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        double a = Math.pow(2,N)/4;
        double b = (Math.pow(Math.sqrt(2),N) * Math.cos((45*N) * (Math.PI/180)))/2;
        System.out.println((int)((a+b)%(Math.pow(10,9) + 13)));
    }
}
