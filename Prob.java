import java.util.*;
public class Prob
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int k = Integer.parseInt(in.nextLine().split(" ")[1]);
        String [] ins = in.nextLine().split(" ");
        //ArrayList<Integer>[] arr = new ArrayList<Integer>[k];
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        for(int x = 0;x<k;x++)
        {
            arr.add(new ArrayList<Integer>());
        }
        for(int x = 0;x<ins.length;x++)
        {
            arr.get(x%k).add(Integer.parseInt(ins[x]));
        }
        ArrayList<Integer> total = new ArrayList<Integer>();
        for(int x = 0;x<arr.size();x++)
        {
            Collections.sort(arr.get(x));
            total.add((int)arr.get(x).get(0));
        }
        Collections.sort(total);
        int totVal = 0;
        for(int x = 0; x<total.size()-1;x++)
        {
            totVal += total.get(x);
        }
        System.out.println(totVal+"");
    }
}