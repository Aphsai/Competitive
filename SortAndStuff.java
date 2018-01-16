/**
 * Created by Saksham on 2016-11-22.
 */

import java.util.*;
import java.io.*;

public class SortAndStuff {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = new String[1000];
        for (int x = 0; x < 1000; x++) {
        token[x] = "";
        }
        String w = "�\tSir Winston Churchill Secondary\n" +
                "�\tDavid Thompson Secondary\n" +
                "�\tDr. Charles Best Secondary School\n" +
                "�\tJN Burnett Secondary School\n" +
                "�\tMoscrop Secondary School\n" +
                "�\tLord Byng Secondary School\n" +
                "�\tMulgrave School\n" +
                "�\tLord Byng Secondary School\n" +
                "�\tBurnaby Central Secondary School\n" +
                "�\tVancouver College\n" +
                "�\tSentinel Secondary School \n" +
                "�\tStratford Hall\n" +
                "�\tPrince of Wales Secondary \n" +
                "�\tPacific Academy\n" +
                "�\tSemiahmoo Secondary School\n" +
                "�\tPoint Grey Secondary\n" +
                "�\tPort Moody Secondary School";
        int counter = 0;
        boolean check = false;
        for (int x = 0; x < w.length(); x++) {
            if ((w.charAt(x) >='A' && w.charAt(x) <='z') || (w.charAt(x) ==' ' || w.charAt(x)=='.')) {
                check = true;
                System.out.println(w.charAt(x));
                token[counter]+=w.charAt(x);
            }
            else {
                token[counter] = token[counter].trim();
                if(check)
                counter++;
                check = false;
            }
        }
        String[] tok = new String[1000];
        counter = 0;
        for (int x =0; x < 1000; x++) {
            if (token[x].length() >= 1 && token[x].charAt(0) != ' ') {
                tok[counter] = token[x];
                System.out.println("<li> " + token[x] + " </li>");
                counter++;
            }

        }

    }

    static int toInt(String s) {
        return Integer.parseInt(s);
    }

    static String[] split(String s) {
        return s.split(" ");
    }

    static String[] read() throws IOException {
        return split(br.readLine());
    }

    static int rInt() throws IOException {
        return toInt(br.readLine());
    }

    static int[] rIntAr() throws IOException {
        String[] temp = read();
        int[] t = new int[temp.length];
        for (int x = 0; x < temp.length; x++) {
            t[x] = toInt(temp[x]);
        }
        return t;
    }
}
