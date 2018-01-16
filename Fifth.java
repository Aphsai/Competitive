/**
 * Created by Saksham on 2016-02-14.
 */
import java.util.Scanner;
public class Fifth {
public static void main(String [] args) {
    Scanner s = new Scanner(System.in);
    int points = s.nextInt();
    int [][] arr = new int[points][2];
    for (int x =0 ;x < points; x++) {
        arr[x][0] = s.nextInt();
        arr[x][1] = s.nextInt();
    }
    double total = 0;
 /*   for (int x =0 ; x < points-1; x++) {
        total += arr[x][0] * arr[x+1][1];
        System.out.println(arr[x][0] * arr[x+1][1]);
        total -= arr[x][1] * arr[x+1][0];
    }
    total += arr[points-1][0] * arr[0][1];
    total -= arr[points-1][1] * arr[1][0];*/
    for (int x= 0 ;x < points; x++) {
        total += arr[x][0] * (arr[x+1 == points? 0: x+1][1] - arr[x-1 == -1? points-1: x-1][1]);
    }
    System.out.println((int)Math.ceil(Math.abs(total/2)));
    }
}

