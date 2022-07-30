package clipboard;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
//import org.junit.asset;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

public static void main(String[] args) throws InterruptedException {

// To initialize the browser
System.setProperty("webdriver.chrome.driver","./Drivers//chromedriver.exe");
WebDriver driver = new ChromeDriver();

// To open amazon
driver.get("https://www.amazon.in/");
driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

// To click on hamburger menu
WebElement hamburgerMenu = driver.findElement(By.id("nav-hamburger-menu"));
hamburgerMenu.click();

    //To click on Television and Electronics
WebElement TVAppliancesAndElectronics = driver.findElement(By.xpath("//div[@id='hmenu-content']//a//div[contains(text(), 'TV, Appliances, Electronics')]"));
TVAppliancesAndElectronics.click();
Thread.sleep(1000);


//To click on Televisions Option
WebElement Televisions = driver.findElement(By.xpath("//a[contains(text(), 'Televisions')]"));
Televisions.click();
Thread.sleep(1000);

//To check the Samsung Checkbox from the left side menu
WebElement SamsungCheckbox = driver.findElement(By.xpath("//span[(text()='Samsung')]//..//i[@class='a-icon a-icon-checkbox']"));
SamsungCheckbox.click();

//To click the SortDropown
WebElement SortDropdown = driver.findElement(By.xpath("//span[@class='a-dropdown-container']"));
SortDropdown.click();

//To click on HighToLow Option
WebElement HighToLow = driver.findElement(By.xpath("//a[text()='Price: High to Low']"));
HighToLow.click();

//To choose and select the second highest value item from the list of search results
List<WebElement> resultsList = driver.findElements(By.xpath(".//span[@class='a-price-whole']"));
    int size = resultsList.size();
    System.out.println("Size of list = " + size);
    Thread.sleep(1000);
    resultsList.get(1).click();
    Thread.sleep(1000);
   
   
    //Window handling
    String parent = driver.getWindowHandle();
   
    Set<String> handles = driver.getWindowHandles();
         
    for(String actual: handles) {
    if(!actual.equalsIgnoreCase(parent)) {
   
    //Switch to the opened tab
    driver.switchTo().window(actual);
    //opening the URL saved.
    }
    }
   
    //To Retrieve the About this item Text
    WebElement aboutThisItemText = driver.findElement(By.xpath("//h1[@class='a-size-base-plus a-text-bold']"));
    String expectedText = aboutThisItemText.getText();
    String actualText = "About this item";
   
    System.out.print(expectedText);
   
   
    //To Compare the About this item text.
    Assert.assertEquals(actualText, expectedText);


driver.quit();


    }

}

