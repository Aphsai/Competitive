import java.util.Scanner;

public class Third {
    public static void main(String [] args) {
        Scanner s = new Scanner(System.in);
        int cases = s.nextInt();
        int pos = 0;
        int [] arr = new int[cases];
        for (int x = 0; x < cases; x++) {
            int num = s.nextInt();
            if (pos != 0 && num == 0) {
            pos--;
            }
            System.out.println(pos + "\t" + num);
            arr[pos] = num;
            if(num !=0)
            pos++;
        }
        int total = 0;
        for (int x = 0; x < arr.length; x++) {
        total += arr[x] ;
        }
    System.out.println(total);
    }
}