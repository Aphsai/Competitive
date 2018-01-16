//Java Culminating Activity
//Shazi Asher
//May 25, 2016
import java.io.*;
import java.util.*;

public class StudentAverage
{
    //Declare file and file readers to be used
    File studentFile;
    FileWriter fw;
    PrintWriter pw;
    //Public class used to write to the notepad document
    public StudentAverage()
    {
        studentFile = new File("students.txt");
        Scanner askScan = new Scanner(System.in);
        System.out.print("Enter the amount of students in the class: ");
        int studentAmount = askScan.nextInt();
        System.out.println();
        String students[] = new String[studentAmount + 1];
        String marks[] = new String[studentAmount +1];
        for(int x = 1; x <= studentAmount; x++)
        {
            System.out.print(x + ". Enter the name of the student: ");
            students[x] = askScan.next();
            System.out.print("   Enter the mark: ");
            marks[x] = askScan.next();
            System.out.println();
        }
        System.out.println("The information has been saved");
        System.out.println("Please enter the mark cut-off for student acceptance:");
        int cutoffMark = askScan.nextInt();
        //Write student names into notepad document
        for (int x = 0; x < 100; x++) { System.out.println();}
        try
        {
            fw = new FileWriter(studentFile);
            pw = new PrintWriter(fw);
            //Write the names to the file
            for(int x = 1; x <= studentAmount; x++)
            {
                pw.println(students[x] + " " + marks[x] + " " + (Integer.parseInt(marks[x]) >= cutoffMark?"PASS":"FAIL"));
                System.out.println(students[x] + " " + marks[x] + " " + (Integer.parseInt(marks[x]) >= cutoffMark?"PASS":"FAIL"));
            }
            pw.close();
        }catch(IOException e){}

    /* READ NUMBER OF LINES
    //Retrieve student names and marks from document
    int lineCount = 0;
    while(studentFile.hasNext())
    {    
    lineCount++;
    studentFile.nextLine();
    }
    studentFile.close();   
    */
    }
    public static void main(String[] args)
    {
        StudentAverage names = new StudentAverage();
    }
}