/**
 * Created by Saksham on 2017-07-13.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;
import java.io.*;

public class GetEndings {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("endings.csv", true));
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saksham\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
                driver.get("http://www.guidingstar.ca/Markham_Business_Directory.htm");
                WebElement container = driver.findElement(By.tagName("td"));
                for (WebElement el : driver.findElements(By.tagName("a"))) {
                   pw.println("\"" + el.getText() + "\",");
                }

        pw.close();
    }

}
