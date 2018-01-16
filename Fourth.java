import java.util.Scanner;

public class Fourth {
  public static void main(String [] args) {
    Scanner s = new Scanner(System.in);
    int lines = s.nextInt();
    String [] arr = new String[lines];
    for (int x =0; x < lines; x++){
      arr[x] = s.next();

  }
  int total = 0;
  for (int x = 0; x < lines; x++) {
    if (arr[x].equals(s.next()))
        total++;
  }
  System.out.println(total);
  }
}