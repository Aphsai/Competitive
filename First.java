import java.io.*;
import java.util.Scanner;
public class First {
    public static void main(String [] args) {
        Scanner s = new Scanner (System.in);
        int people = s.nextInt();
        int old = 0;
        int young = 0;
        for (int x =0 ;x < people;x++) {
           int age = s.nextInt();
            if (age > 14)
            old++;
            else if (age <= 14 && age > 0)
            young++;
        }
        if (young > 0)
        System.out.println(young + " are too young to play.");
        if (old > 12)
        System.out.println("There are too many people who want to play.");
        else if (old < 12)
        System.out.println("There are not enough people to play.");
        else
        System.out.println("Time to play!");
        
    }
}