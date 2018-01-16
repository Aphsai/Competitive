/**
 * Created by Saksham on 2016-02-16.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Seventh {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int J = Integer.parseInt(br.readLine()),A = Integer.parseInt(br.readLine());
        int [] jersey = new int[J];
        for (int x =0; x < J; x++) {
            String token = br.readLine();
            if (token.equals("S")) {
                jersey[x] = 0;
            }
            else if (token.equals("M")){
                jersey[x] = 1;
            }
            else
                jersey[x] = 2;
        }
        int total = 0;
        for (int x = 0;x  < A; x++) {
            String token = br.readLine();
            String size = token.split(" ")[0];
            int jers = 0;
            int num = Integer.parseInt(token.split(" ")[1]);
            if (size.equals("S")) {
                jers = 0;
            }
            else if (size.equals("M")){
                jers = 1;
            }
            else
                jers = 2;
            if (jers <= jersey[num-1]){
                total++;
                jersey[num-1] = -1;
            }
        }
        System.out.println(total);

    }
}
