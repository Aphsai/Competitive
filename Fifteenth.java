/**
 * Created by Saksham on 2016-02-20.
 */
import java.util.*;
public class Fifteenth {
    static int[] recurs (int [] arr, int index, int sum, int skip) {

        int [] newer = new int [arr.length];
        System.arraycopy(arr, 0, newer, 0, index);
        if (skip != 0)
            newer[index] = sum;
        else
            newer[index] = arr[index];
        //    System.out.println("INDEX: " + index + "\t SUM: " + sum + "\t SKIP: " + skip);
        if (index+skip == 0) {
            System.arraycopy(arr,0,newer,0,arr.length);
        }
        else {
            if (index != arr.length - 1 || index + skip > arr.length - 1)
                System.arraycopy(arr, index + skip + 1, newer, index + skip, arr.length - index - skip - 1);
        }
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int x =0 ; x < newer.length; x++) {
            set.add(newer[x]);
        }
        while(!set.isEmpty()) {
            int search = set.pollLast();
                for (int x= 0; x < newer.length; x++) {
                    if (newer[x] == search) {
                        index = x;
                        break;
                    }
                }
            if (index!= newer.length-2 && index!= arr.length-1 && newer[index]!= 0 &&  newer[index] == newer[index+2]) {
                sum = newer[index] + newer[index + 1] + newer[index + 2];
                newer = recurs(newer, index, sum, 2);
                break;
            }
            else if (newer[index] != 0 && index != arr.length-1 && newer[index] == newer[index+1]) {
                sum = newer[index] + newer[index+1];
                newer = recurs(newer,index, sum, 1);
                break;
            }

        }
        return newer;
//        for (int  x= 0; x < newer.length; x++) {
//            System.out.print(newer[x] + " ");
//
//        }

  /*      for (int  x= 0; x < newer.length-1; x++) {    
            //  System.out.println(newer[x]);
            if (x!= newer.length-2 && newer[x]!= 0 &&  newer[x] == newer[x+2]) {
                if (x != newer.length-3 && newer[x+1] == newer[x+3] && newer[x+1] > newer[x]) {

                        sum = newer[x+1] + newer[x+2] + newer[x+3];
                        newer = recurs(newer, x+1, sum, 2);
                        break;

                }
                else {
                    sum = newer[x] + newer[x + 1] + newer[x + 2];
                    newer = recurs(newer, x, sum, 2);
                    break;
                }
            }
            else if (newer[x] != 0 && newer[x] == newer[x+1]) {
                if (x != newer.length-3 && newer[x+1] == newer[x+3] && newer[x+1] > newer[x]) {

                    sum = newer[x+1] + newer[x+2] + newer[x+3];
                    newer = recurs(newer, x+1, sum, 2);
                    break;

                }
                sum = newer[x] + newer[x+1];
                newer = recurs(newer, x, sum, 1);
                break;
            }

        }*/
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int [] array =new int[N];
        for (int x= 0; x< N; x++) {
            array[x] = s.nextInt();
        }

        array = Fifteenth.recurs(array, 0, 0, 0);
        int max = 0;
        for (int x =0; x < array.length; x++) {
            if (max < array[x]) {
                max = array[x];
            }
        }
        System.out.println(max);
    }
}
