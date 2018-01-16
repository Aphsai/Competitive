/**
 * Created by Saksham on 2016-02-20.
 */
import java.util.*;
import java.io.*;
public class Thirteenth {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] set = br.readLine().split(" ");
        String [] set2 = br.readLine().split(" ");
        for (int x = 0;x  < N; x++) {
            for (int y = 0; y < N; y++) {
                if (set[x].equals(set2[y])) {
                    if (!set[y].equals(set2[x]) || set[y].equals(set[x])) {
                        System.out.println("bad");
                        return;
                    }
                }
            }
        }
        System.out.println("good");
    }
}
