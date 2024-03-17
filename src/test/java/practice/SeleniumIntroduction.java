package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumIntroduction {
    public static void main(String args[]) {
        //https://googlechromelabs.github.io/chrome-for-testing/
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        //if property not set, SeleniumManager will take care of invoking the browser
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");

        WebElement precedingElement = driver.findElement(By.xpath("//div[@class='_3sdu8W emupdz'] /*[@aria-label='Travel']/preceding-sibling::a[1]"));
        System.out.println(precedingElement.getText());

        List<WebElement> links = driver.findElements(By.xpath("//a"));
        System.out.println("Count of links: " + links.size());

        List<WebElement> items =driver.findElements(By.xpath("//div[@class='_3sdu8W emupdz'] /*"));

        for(int i=0;i<items.size();i++) {
            if((items.get(i).getText().equals("Travel")) && i>0) {
                System.out.println(items.get(i-1).getText());
            }
        }

        driver.close();
    }
}
