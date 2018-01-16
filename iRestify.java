/**
 * Created by Saksham on 2017-07-04.
 */

import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class iRestify {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
            PrintWriter pw = new PrintWriter(new FileWriter("mov&stor.csv", true));
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saksham\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String[] arr = {"Accountants",
                "Air Conditioning & Heating",
                "Architects",
                "Art_Classes_Art_Workshops_Art_Activities",
                "Art Galleries",
                "Artists & Groups",
                "Associations",
                "Automation System ",
                "Automotive Services",
                "Aviation",
                "Banks",
                "Banquet Halls",
                "Bed & Breakfast Accommodations",
                "Bedding and Mattress",
                "Birthday Products & Services",
                "Book Stores",
                "Business Consultants",
                "Business Services",
                "Cafes",
                "Car Dealers",
                "Car Rentals",
                "Care Givers",
                "Caterers",
                "Chiropractors",
                "Churches",
                "Cleaning Services",
                "Community Centres",
                "Communications",
                "Computer Companies",
                "Computer Services",
                "Computer Stores",
                "Continuing Education",
                "Cosmetics & Skin Care",
                "Courier Companies",
                "Crafts & Art Supplies",
                "Dance Studios",
                "Day Camps",
                "Day Care Centres",
                "Decks & Patios",
                "Dentists",
                "Department Stores",
                "Driving School",
                "Drug Stores",
                "Electronics",
                "Employment Agencies & Centres",
                "Engineering Companies",
                "Entertainment",
                "Events Management Planning",
                "Eye Wear",
                "Family Physicians",
                "Family & Youth Services",
                "Farms",
                "Ladies",
                "Men",
                "Children",
                "Fast Food Restaurants",
                "Financial Planners",
                "Financial Services Companies",
                "Fitness Centres",
                "Fitness Equipment Stores",
                "Florists",
                "Food Companies",
                "French Classes",
                "Galleries",
                "Garden Centres",
                "Garden & Horticultural Societies",
                "General Contractors",
                "Gift Products",
                "Golf Courses & Driving Range",
                "Government",
                "Graphics",
                "Hair Salons",
                "Hardware Stores",
                "Health Care Services",
                "Home Furnishings",
                "Home Improvements",
                "Hospitals",
                "Hotels",
                "Industrial Sales",
                "Insurance",
                "Jewellers",
                "Landscaping",
                "Lawyers",
                "Libraries",
                "Manufacturing Companies",
                "Marketing Companies",
                "Martial Arts Studios",
                "Massage Therapy",
                "Maternity Health Care",
                "Medical Centres",
                "Moving Companies & Storage",
                "Mortgage Agents and Brokers",
                "Music",
                "Naturopathic Doctors",
                "New Homes & Condominiums",
                "Office Supplies & Furnishings",
                "Optometrists",
                "Personal Training",
                "Pet Stores & Services",
                "Photo Development",
                "Post Offices & Outlets",
                "Prenatal",
                "Printing & Publishing Co.",
                "Public Transits",
                "Pubs",
                "Real Estate Agencies & Services",
                "Restaurants",
                "Retail Stores",
                "Retirement Homes",
                "Private_Schools",
                "Public_Schools",
                "Public_High_Schools",
                "Catholic_Elementary_Schools",
                "Catholic_High_Schools",
                "School Boards",
                "Seniors Activities & Services",
                "Shoes Stores",
                "Shopping Plazas & Centres",
                "Snow Removal Companies",
                "Software for Business",
                "Spas & Salons",
                "Special Occasion Cards",
                "Specialists in Downsizing and Moving for Seniors",
                "Sporting Goods Stores",
                "Sports Clubs",
                "Supermarkets",
                "Swimming Pools",
                "Travel Agencies",
                "Tourism",
                "Tour Operators",
                "Toy Stores",
                "Tutoring Services",
                "Wedding Gifts",
                "Wedding Gowns",
                "Wedding Video Production & Photography",
                "Wellness Centres",
                "Yachts",
                "Youth Organizations"};
        boolean check = true;
        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        JavascriptExecutor js = (JavascriptExecutor) driver;
            try {
//                for (String str : arr) {
//                    str = str.replace(" ", "_");
                driver.get("http://www.toronto.net/Moving_and_Storage.html");
                String originalHandle = driver.getWindowHandle();
                List<WebElement> arra = driver.findElements(By.className("commands"));
                outer: for (WebElement ele : driver.findElements(By.className("commands"))) {
                    ele.findElement(By.tagName("a")).sendKeys(selectLinkOpeninNewTab);
                    for (String handle : driver.getWindowHandles()) {
                        if (handle.equals(originalHandle))
                            continue;
                        driver.switchTo().window(handle);
                        WebElement el = driver.findElement(By.id("site_info"));
                        String name = el.findElement(By.tagName("h1")).getText();
//                        System.out.println(name);
                        String t = "Telephone:";
                        String e = "E-mail:";
                        try {
                            List<WebElement> ar = getWhenVisible(By.className("contacts"), 1000, driver).findElements(By.className("address"));
                            String tel = ar.get(1).getText();
                            String text = ar.get(2).getText();

//                            System.out.println(tel + " " + text);
                            try {
                                String phone = tel.substring(text.indexOf(t) + t.length() + 1, text.indexOf("\n")).trim();
                                String email = text.substring(text.indexOf(e) + e.length()).trim();

                                pw.println(name + "," + phone + "," + email);
                            } catch (Exception ex) {
                                driver.close();
                                driver.switchTo().window(originalHandle);
                                ex.printStackTrace();
                                continue outer;
                            }
                        } catch (Exception exe) {
                            driver.close();
                            driver.switchTo().window(originalHandle);
                            continue outer;
                        }

//                        getClickable(By.xpath("//ul//div[2]//a"), 1000, driver).click();
                    }
                    driver.close();
                    driver.switchTo().window(originalHandle);

                }
            }catch(Exception e){
                    e.printStackTrace();
                    pw.flush();
                }
        pw.close();
    }
    static WebElement getWhenVisible(By locator, int timeout, WebDriver driver) {
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }
    static WebElement getClickable(By locator, int timeout, WebDriver driver) {
        WebElement element = null;
        try {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {}
        return element;
    }
}
